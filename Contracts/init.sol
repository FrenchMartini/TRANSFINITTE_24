// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract PatentRegistry {

    // Struct to store patent information
    struct Patent {
        string title;
        string description;
        address owner;
        uint256 registrationDate;
        uint256 expirationDate;
        string ipfsHash; // IPFS hash for the patent file
    }

    // Constants
    uint256 public constant DURATION = 365 * 24 * 60 * 60; // 1 year in seconds
    uint256 public constant registrationFee = 0.01 ether; // Fee for registration
    uint256 public constant transferFee = 0.005 ether; // Fee for patent transfer
    uint256 public constant renewalFee = 0.002 ether; // Fee for renewal

    // Counter for unique patent IDs
    uint256 public patentCounter;

    // Mapping to store patents with unique patent ID
    mapping(uint256 => Patent) public patents;

    // Mapping to store patents owned by an address
    mapping(address => uint256[]) public ownerPatents;

    // Events to emit when patents are registered, transferred, or renewed
    event PatentRegistered(uint256 patentId, string title, address owner, string ipfsHash);
    event PatentTransferred(uint256 patentId, address from, address to);
    event PatentRenewed(uint256 patentId, uint256 newExpirationDate);

    constructor() {
        patentCounter = 0; // Initialize the patent ID counter
    }

    // Function to register a new patent (requires registration fee and IPFS hash)
    function registerPatent(string memory _title, string memory _description, string memory _ipfsHash) public payable {
        require(msg.value >= registrationFee, "Insufficient registration fee");

        patentCounter++;
        uint256 newPatentId = patentCounter;

        // Store patent information including the IPFS hash
        patents[newPatentId] = Patent({
            title: _title,
            description: _description,
            owner: msg.sender,
            registrationDate: block.timestamp,
            expirationDate: block.timestamp + DURATION,
            ipfsHash: _ipfsHash
        });

        // Track patent ownership
        ownerPatents[msg.sender].push(newPatentId);

        // Emit event when a patent is registered
        emit PatentRegistered(newPatentId, _title, msg.sender, _ipfsHash);
    }

    // Function to transfer a patent from the current owner to another address (requires transfer fee)
    function transferPatent(uint256 _patentId, address _to) public payable {
        require(msg.value >= transferFee, "Insufficient transfer fee");
        require(patents[_patentId].owner == msg.sender, "You are not the owner of this patent");
        require(block.timestamp <= patents[_patentId].expirationDate, "Patent has expired, renew it before transfer");

        // Transfer ownership
        patents[_patentId].owner = _to;

        // Remove the patent from the current owner's list
        _removePatentFromOwner(msg.sender, _patentId);

        // Add the patent to the new owner's list
        ownerPatents[_to].push(_patentId);

        // Emit event when a patent is transferred
        emit PatentTransferred(_patentId, msg.sender, _to);
    }

    // Function to renew an expired patent (requires renewal fee)
    function renewPatent(uint256 _patentId) public payable {
        require(msg.value >= renewalFee, "Insufficient renewal fee");
        require(patents[_patentId].owner == msg.sender, "You are not the owner of this patent");

        // Extend expiration date
        patents[_patentId].expirationDate += DURATION;

        // Emit event when a patent is renewed
        emit PatentRenewed(_patentId, patents[_patentId].expirationDate);
    }

    // Function to get the details of a patent
    function getPatentDetails(uint256 _patentId) public view returns (string memory title, string memory description, address owner, uint256 registrationDate, uint256 expirationDate, string memory ipfsHash) {
        Patent memory patent = patents[_patentId];
        return (patent.title, patent.description, patent.owner, patent.registrationDate, patent.expirationDate, patent.ipfsHash);
    }

    // Function to get all patents owned by a specific address
    function getOwnerPatents(address _owner) public view returns (uint256[] memory) {
        return ownerPatents[_owner];
    }

    // Internal function to remove a patent from the current owner's list
    function _removePatentFromOwner(address _owner, uint256 _patentId) internal {
        uint256 length = ownerPatents[_owner].length;
        for (uint256 i = 0; i < length; i++) {
            if (ownerPatents[_owner][i] == _patentId) {
                ownerPatents[_owner][i] = ownerPatents[_owner][length - 1];
                ownerPatents[_owner].pop();
                break;
            }
        }
    }

    // Function to withdraw the collected fees from the contract (only by contract owner)
    function withdrawFees() public {
        payable(msg.sender).transfer(address(this).balance);
    }
}

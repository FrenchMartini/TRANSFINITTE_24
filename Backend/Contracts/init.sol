// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract PatentRegistry {

    // Struct to store patent information
    struct Patent {
        string title;
        string description;
        address owner;
    }

    // Counter for unique patent IDs
    uint256 public patentCounter;

    // Mapping to store patents with unique patent ID
    mapping(uint256 => Patent) public patents;
    
    // Mapping to store patents owned by an address
    mapping(address => uint256[]) public ownerPatents;

    // Events to emit when patents are registered or transferred
    event PatentRegistered(uint256 patentId, string title, address owner);
    event PatentTransferred(uint256 patentId, address from, address to);

    constructor() {
        patentCounter = 0; // Initialize the patent ID counter
    }

    // Function to register a new patent
    function registerPatent(string memory _title, string memory _description) public {
        patentCounter++;
        uint256 newPatentId = patentCounter;

        // Store patent information
        patents[newPatentId] = Patent({
            title: _title,
            description: _description,
            owner: msg.sender
        });

        // Track patent ownership
        ownerPatents[msg.sender].push(newPatentId);

        // Emit event when a patent is registered
        emit PatentRegistered(newPatentId, _title, msg.sender);
    }

    // Function to transfer a patent from the current owner to another address
    function transferPatent(uint256 _patentId, address _to) public {
        // Ensure that the sender is the owner of the patent
        require(patents[_patentId].owner == msg.sender, "You are not the owner of this patent");

        // Transfer ownership
        patents[_patentId].owner = _to;

        // Remove the patent from the current owner's list
        _removePatentFromOwner(msg.sender, _patentId);

        // Add the patent to the new owner's list
        ownerPatents[_to].push(_patentId);

        // Emit event when a patent is transferred
        emit PatentTransferred(_patentId, msg.sender, _to);
    }

    // Function to get the details of a patent
    function getPatentDetails(uint256 _patentId) public view returns (string memory title, string memory description, address owner) {
        Patent memory patent = patents[_patentId];
        return (patent.title, patent.description, patent.owner);
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
}
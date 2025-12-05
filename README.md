# Network Programming & Computer Networking Materials

> Complete collection of course materials for Computer Networking, Socket Programming, and Multithreading

![GitHub repo size](https://img.shields.io/github/repo-size/Chriszhengzx/Network-Programming?style=flat-square)
![GitHub last commit](https://img.shields.io/github/last-commit/Chriszhengzx/Network-Programming?style=flat-square)
![GitHub license](https://img.shields.io/github/license/Chriszhengzx/Network-Programming?style=flat-square)

## 📋 Overview

This repository contains comprehensive course materials for learning:
- **Computer Networking Fundamentals** (OSI/TCP-IP models, protocols, subnetting)
- **Transport Layer Protocols** (TCP vs UDP, ports, flow control)
- **Application Layer Protocols** (HTTP, DNS, SMTP, DHCP, FTP)
- **Java Socket Programming** (TCP/UDP clients and servers)
- **Java Multithreading** (concurrent programming)

Perfect for students, developers, and anyone preparing for networking certifications (CCNA, Network+).

## 📁 Repository Structure
Network-Programming/
├── 📘 Slides/ # Course presentation slides
│ ├── Module_14_Transport Layer.pdf
│ └── Module_15_Application Layer.pdf
│
├── 📚 Textbooks & Guides/ # Detailed guides and textbooks
│ ├── Socket programming_v2.pdf
│ └── Threads.pdf
│
├── 📝 Exams & Practice/ # Assessment materials
│ └── Final-exam-practice.pdf
│
├── 🔧 Network Configuration/ # Network design exercises
│ └── VLSM_sample_question.txt
│
├── 💻 Code Examples/ # Java programming examples
│ ├── TCP_Client_Server/
│ ├── UDP_Client_Server/
│ └── Multithreading_Examples/
│
└── 📄 Documentation/ # Additional notes and guides
└── README.md (this file)

text

## 📖 Learning Path

### Phase 1: Networking Fundamentals
1. **Transport Layer** (`Module_14_Transport Layer.pdf`)
   - TCP vs UDP comparison
   - Port numbers and socket pairs
   - Three-way handshake & four-way termination
   - Flow control and congestion avoidance

2. **Application Layer** (`Module_15_Application Layer.pdf`)
   - HTTP/HTTPS, SMTP, POP3, IMAP
   - DNS resolution and DHCP operation
   - FTP and SMB file sharing
   - Peer-to-peer networks

### Phase 2: Programming Implementation
3. **Socket Programming** (`Socket programming_v2.pdf`)
   - TCP stream sockets
   - UDP datagram sockets
   - Client-server architecture
   - Java socket API usage

4. **Multithreading** (`Threads.pdf`)
   - Thread creation and lifecycle
   - Synchronization and shared resources
   - Thread priorities and scheduling
   - Concurrent server design

### Phase 3: Practical Exercises
5. **Exam Preparation** (`Final-exam-practice.pdf`)
   - Multiple choice questions
   - Subnetting problems
   - Protocol analysis
   - Troubleshooting scenarios

6. **Network Design** (`VLSM_sample_question.txt`)
   - Variable Length Subnet Masking
   - IP address allocation
   - Network planning exercises

## 🔗 Direct File Links

### Course Slides
- [Transport Layer Slides](./Module_14_Transport%20Layer.pdf) - TCP/UDP, ports, reliability
- [Application Layer Slides](./Module_15_Application%20Layer.pdf) - HTTP, DNS, email protocols

### Programming Guides
- [Socket Programming Guide](./Socket%20programming_v2.pdf) - Java TCP/UDP implementation
- [Multithreading Guide](./Threads.pdf) - Java concurrent programming

### Practice Materials
- [Final Exam Practice](./Final-exam-practice.pdf) - 26 review questions with solutions
- [VLSM Sample Question](./VLSM_sample_question.txt) - Subnetting exercise with step-by-step solution

## 🚀 Quick Start

### For Students
1. Start with Transport Layer concepts
2. Move to Application Layer protocols
3. Practice with exam questions
4. Implement concepts using Socket Programming
5. Extend with Multithreading for concurrent servers

### For Developers
```bash
# Clone the repository
git clone https://github.com/Chriszhengzx/Network-Programming.git

# Navigate to code examples
cd Network-Programming/Code_Examples/

# Compile and run TCP example
javac TCPEchoServer.java
java TCPEchoServer
🧪 Sample Code Structure
java
// Basic TCP Server Example
import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server listening on port 8888...");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            // Handle client connection
            new ClientHandler(clientSocket).start();
        }
    }
}
📊 Key Topics Covered
Topic	Files	Key Concepts
TCP/UDP	Module 14, Socket PDF	Ports, segmentation, reliability, flow control
HTTP/DNS	Module 15	Web protocols, name resolution, email systems
Socket Programming	Socket PDF	TCP/UDP sockets, data streams, packet handling
Multithreading	Threads PDF	Concurrency, synchronization, thread management
Network Design	VLSM file	Subnetting, IP allocation, network planning
🛠 Prerequisites
Basic understanding of computer networks

Java programming knowledge (for code examples)

Network simulation tools like Cisco Packet Tracer (optional)

Java Development Kit (JDK) installed

📈 Learning Outcomes
By studying these materials, you will be able to:

Explain the differences between TCP and UDP

Configure and troubleshoot network services

Implement client-server applications using sockets

Design concurrent network applications

Solve subnetting and VLSM problems

Prepare for networking certification exams

🔄 Updates
Initial Upload: April 2025 - All core course materials

Future Plans: Add more code examples, lab exercises, and video tutorials

🤝 Contributing
Contributions are welcome! If you have additional materials or improvements:

Fork the repository

Create a feature branch

Commit your changes

Push to the branch

Open a Pull Request

📄 License
This repository is intended for educational purposes only. The materials are provided as-is for personal study and reference.

Course slides may contain content from Cisco Networking Academy

All materials should be used in accordance with fair use policies

Commercial use or redistribution may require additional permissions

👨‍🏫 Author
Chris Zheng

GitHub: @Chriszhengzx

Repository: Network-Programming

📞 Support
For questions or issues:

Open an Issue

Review the materials thoroughly before asking

Provide specific details about your question

Happy Learning! 🌐💻

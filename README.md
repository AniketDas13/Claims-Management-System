# Claims-Management-System
A mediclaim management webapp made using Java Full Stack
---------------------------------------------------------
A mediclaim management webapp catering to user requirements by providing them with services to submit claims, view claim status, and show available policies in a user-friendly interface based upon microservices architecture.

This project primarily consists of four modules designated to perform distinct operations:
1. Member Portal: A Web Portal that allows a member to Login and allows to do the following operations:
- Login
- View Current Bill Status, Next Due
- Verify Claim Status
- Submit a Claim

2. Claims Module: Claims Module is a Middleware Microservice that performs the following operations:
- Get Claim Status
- Validate Eligibility of Claim and Action Settlement

3. Member Module: Member Module is a Middleware Microservice that performs the following operations:
- View Bills
- Submit Claim
- View Claim Status

4. Policy Module: Policy Module is a Middleware Microservice that performs the following operations:
- Get a Chain of Permissible Providers (Hospitals)
- Get Benefits permissible under a policy
- Get an Acceptable Claim Amount per benefit, per policy

![image](https://user-images.githubusercontent.com/37765408/225891538-c63f73d0-855f-4dfd-acde-760b290a6461.png)

Aniket Das (AniketDas13)

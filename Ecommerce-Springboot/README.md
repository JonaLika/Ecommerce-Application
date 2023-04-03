# E-commerce Application

This is a Spring MVC E-commerce project that is separated into three modules: Admin, Customer, and Library. The project is designed to allow users to browse and purchase products, while also providing an admin interface for managing inventory and orders.

## Technologies Used
- Spring MVC
- Thymeleaf
- MySQL
- Hibernate
- Maven


## Modules

1. Admin

The Admin module provides an interface for managing products, orders, and customers. The Admin can add, edit, and delete products, view order details, and manage customer accounts. The module includes a login page with authentication and authorization, as well as error handling and validation.

2. Customer

The Customer module allows users to browse products, add items to their cart, and checkout. The module includes a product catalog with pagination, search, and sorting capabilities, as well as a shopping cart and checkout process. The module also includes user registration and login functionality, as well as error handling and validation.

3. Library
The Library module provides utility classes and methods for the other modules to use. This includes database access, data models, and other shared functionality.

4. Database
The project uses MySQL for database storage. The database schema includes tables for products, orders, customers, and users.

## Issues
This project is a work in progress and there are a few things that need to be fixed:

- The admin interface needs to be improved to provide more information about orders and customers.
- The checkout process needs to be optimized for better user experience and fewer errors.
- The search functionality needs to be updated to provide more accurate results.
- The project needs more unit and integration tests to ensure code quality and reliability.

## Getting Started

To get started with this project, follow these steps:

- Clone the repository to your local machine
- Import the project into your preferred IDE
- Configure your MySQL database settings in application.properties
- Run the project and navigate to localhost:8020/shop and localhost:8019/admin in your web browser


## Conclusion
This Spring MVC E-commerce project is a modular and scalable web application that provides separate modules for admin and customer functionality. While still a work in progress with a few issues to address, it has the potential to become a reliable and robust E-commerce platform with further development and optimization.
# iCheck
A simple object-oriented, menu-driven Java program calculates demerit points from infringement.


## Table of Contents
1. [About the projects](#about-the-project)
2. [Technologies](#technologies)
3. [Features](#features)
4. [Text files to be processed](#text-files-to-be-processed)
5. [Setup](#setup)
6. [Contributing](#contributing)


## About the project
This project is a WSU Assignment that aims to create an object-oriented, menu-driven Java program. This program implements implements a simplified range of functionalities relating to infringements for speeding offences and the resulting demerit point calculations. The Java  program will retrieve data from secondary storage, store the data in memory in appropriate data structures using objects, sort and search the data, generate on-screen and file-based reports, and save data to secondary storage.


## Technologies
Project is created with:
* Java


## Features
#### Display Drivers
* Display an on-screen list of all drivers that were loaded into memory.
* Also be able to display the report in descending-order of the Demerit Points.

#### Import Infringement File
* Import the chosen infringement file by the user into memory.
* For each infringement, apply the penalties based upon the Excess Speed, to the relevant driver licence record in memory.
* Display an on-screen summary report that shows the total number of infringements correctly applied to drivers, the total revenue from fines correctly applied to drivers, the total number of licences suspended.

#### Generate Suspension Report
* Generate an on-screen list of the driver licences that are currently suspended.

#### Save Driver Records
* Write all driver licence records back to the driver.txt text file.

#### Exit Program
* The program terminate.


## Text files to be processed
#### Driver.txt
*  Contains a full record of unrestricted NSW driver licence holders
*  Each line within the file represents an individual driver
*  Has the following format: Licence Number, Licence Class, First Name, Last Name, Address, Suburb, Postcode, Demerit Points, Licence Status

*The program should read data from this file into computer memory into an appropriate array of objects before display the menu*

#### Infringement#.txt
* Record infringements for drivers that have committed a speeding offence that has a demerit point penalty
* Each line within the files represent an individual infringement for a driver
* Has the following format: Infringement Number, Licence Number, Date of Infringement, Excess Speed

*There are 4 infringement files in this program. Each file represents a different set of infringements and can be applied to the driver record sequentially.*


## Setup
#### Prerequisites
* Eclispe IDE

#### Installation
* Open Eclispe IDE
* Select Window > Show views > Other > Git > Git Repositories > Clone a Git repository
* Enter the link https://github.com/longta119/iCheck in the URL


## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

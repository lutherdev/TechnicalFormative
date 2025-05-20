package com.example.technicalformative

/*
Modify your work in [M1-TECHNICAL] by putting all information inside a class named Employee.
The class must inherit from a Person class. Additionally, Add a third class named Student.
The properties for each class are as follows:

Person: First Name, Middle Name, Last Name, Birthday, Gender, and Address
Employee: TIN (can accept the input 'N/A'), SSS Number (can accept the input 'N/A'), PhilHealth Number (can accept the input 'N/A'), School Graduated From (College Degree), Year Graduated, Knowledge/Skills (at most 3), and Personal References (at least 3, with contact numbers)
Student: Degree Program, Year Level, Specialization (can accept the input 'N/A'), Section
Each class must have its corresponding functions to set or get the information.

Your program must have a menu to ask the user what kind of information to input. Display all information after inputting all data.
 */



open class Person (val firstName: String, val middleName: String, val lastName: String, val bDate: String, val gender: String, val address: String){

    open fun displayPerson(){
        println("Name: ")
        println("Birthdate: ")
        println("Gender: ")
        println("Address: ")
    }
}

class Employee (firstName: String, middleName: String, lastName: String, birthday: String, gender: String, address: String, val tin: String, val sss: String, val philhealth: String, val schoolGraduatedFrom: String, val yearGraduated: Int, val knowledgeSkills: List<String>, val personalReferences: List<Pair<String, String>>) : Person(firstName, middleName, lastName, birthday, gender, address){
    override fun displayPerson() {
        super.displayPerson()
        println("tin: ")
        println("SSS: ")
        println("Philhealth: ")
        println("School Graduated from: ")
        println("Year Graduated: ")
        println("Knowledge/Skills: ")
        println("Personal References: ")
    }
}

class Student(firstName: String, middleName: String, lastName: String, birthday: String, gender: String, address: String, val degree: String, val yearLevel: String, val specialization:String, val section: String) : Person(firstName, middleName, lastName, birthday, gender, address){
    override fun displayPerson() {
        super.displayPerson()
        println("Degree: ")
        println("Year Level: ")
        println("Specialization: ")
        println("Section: ")
    }
}


fun main(){
    for (i in 1..5){
        print(i)
    }
    print("Enter your first name            : ")
    val fname = readln()
    print("Enter your last name             : ")
    val lname = readln()
    print("Enter your middle name           : ")
    val mname = readln()
    print("Enter your birthdate (yyyy/mm/dd): ")
    val bdate = readln()

    val bdateInt = bdate.split("/")
    val age = 2025 - bdateInt[0].toInt()

    print("Enter your gender                : ")
    val gender = readln()
    print("Enter your address               : ")
    val addr = readln()
    print("Enter your TIN                   : ")
    val tin = readln()
    print("Enter your SSS Number            : ")
    val sss = readln()
    print("Enter your PhilHealth Number     : ")
    val phil = readln()
    print("Enter your School Graduated From (College Degree): ")
    val school = readln()
    print("Enter your Year Graduated        : ")
    val yrGrad = readln()

    print("How many knowledge/skill/s would u like to input? ")
    val numSki = readln().toInt()
    val skills = Array(numSki){""}

    for (i in 0 until numSki){
        print("Enter your Knowledge/Skill      : ")
        skills[i] = readln()
    }

    print("How many Personal Reference/s would u like to input? ")
    val numPer = readln().toInt()
    val namePer = Array(numPer){""}
    val conPer = Array(numPer){""}
    for (i in 0 until numPer){
        print("Enter your Person's Name         : ")
        namePer[i] = readln()
        print("Enter your Person's Number       : ")
        conPer[i] = readln()
    }

    println("=====================================================")
    println("$fname's biodata")
    println("------------------------------------------------------")
    println("full name                    : $fname $mname $lname")
    println("Birth date                   : $bdate")
    println("Age                          : $age")
    println("Gender                       : $gender")
    println("Address                      : $addr")
    println("TIN                          : $tin")
    println("SSS                          : $sss")
    println("PhilHealth                   : $phil")
    println("School Graduated             : $school")
    println("Year Graduated               : $yrGrad")
    print("Your knowledge/skills are    : ")
    for (skill in skills){
        print("$skill ")
    }
    println("\nYour Personal References     : ")
    for (i in 0 until numPer){
        println("---------------------------------------------------")
        println("Person #${i+1}")
        println("Name                         : ${namePer[i]}")
        println("Number                       : ${conPer[i]}")
    }
    println("=====================================================")
}
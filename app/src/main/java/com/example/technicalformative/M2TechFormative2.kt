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
    val age: Int

    init {
        age = calculateAge(this.bDate)
    }

    private fun calculateAge(bDate: String): Int{
        val bdateInt = bDate.split("/")
        val age = 2025 - bdateInt[0].toInt()
        return age
    }

    open fun displayPerson(){
        println("=====================================================")
        println("$firstName's biodata")
        println("------------------------------------------------------")
        println("Name: $firstName $middleName $lastName")
        println("Birthdate: $bDate")
        println("Age: $age")
        println("Gender: $gender")
        println("Address: $address")
        println("------------------------------------------------------")
    }
}

class Employee (firstName: String, middleName: String, lastName: String, birthday: String, gender: String, address: String, val tin: String, val sss: String, val philhealth: String, val schoolGraduated: String, val yearGraduated: String, val knowledgeSkills: Array<String>, val personalReferences: MutableMap<String, String>) : Person(firstName, middleName, lastName, birthday, gender, address){
    override fun displayPerson() {
        super.displayPerson()
        println("Employee Information: ")
        println("------------------------------------------------------")
        println("tin: $tin")
        println("SSS: $sss")
        println("Philhealth: $philhealth")
        println("School Graduated from: $schoolGraduated")
        println("Year Graduated: $yearGraduated")
        print("Your knowledge/skills are    : ")
        for (skill in knowledgeSkills){
            print("$skill, ")
        }
        println("\nYour Personal References     : ")
        for ((name, number) in personalReferences){
            println("---------------------------------------------------")
            println("Name                         : $name")
            println("Number                       : $number")
        }
        println("=====================================================")
    }
}

class Student(firstName: String, middleName: String, lastName: String, birthday: String, gender: String, address: String, val degree: String, val yearLevel: String, val specialization:String, val section: String) : Person(firstName, middleName, lastName, birthday, gender, address){
    override fun displayPerson() {
        super.displayPerson()
        println("Student Information: ")
        println("------------------------------------------------------")
        println("Degree: $degree")
        println("Year Level: $yearLevel")
        println("Specialization: $specialization")
        println("Section: $section")
        println("=====================================================")
    }
}

fun main(){

    println("                HELLO WELCOME USER!            ")
    print("What information would you like to input? Employee[1] Student[2]: ")
    val choice = readln().toInt()

    print("Enter your first name            : ")
    val fname = readln()
    print("Enter your last name             : ")
    val lname = readln()
    print("Enter your middle name           : ")
    val mname = readln()
    print("Enter your birthdate (yyyy/mm/dd): ")
    val bdate = readln()
    print("Enter your gender                : ")
    val gender = readln()
    print("Enter your address               : ")
    val addr = readln()

    when(choice){
        1 -> {
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
                print("Enter your Knowledge/Skill[${i+1}]:")
                skills[i] = readln()
            }
            print("How many Personal Reference/s would u like to input? ")
            val numPer = readln().toInt()
            val personalReferences: MutableMap<String, String> = mutableMapOf()

            for (i in 0 until numPer){
                print("Enter your Person's Name [${i+1}]: ")
                val namePer = readln()
                print("Enter your Person's Number[${i+1}]: ")
                val conPer = readln()
                personalReferences[namePer] = conPer
            }
            val emp: Employee = Employee(fname, mname, lname, bdate, gender, addr, tin, sss, phil, school, yrGrad, skills, personalReferences)
            emp.displayPerson()
        }
        2 -> {
            print("Enter your Degree                : ")
            val degree = readln()
            print("Enter your Year Level            : ")
            val yearLevel = readln()
            print("Enter your Specialization       : ")
            val specialization = readln()
            print("Enter your Section               :")
            val section = readln()

            val stud: Student = Student(fname, mname, lname, bdate, gender, addr, degree, yearLevel, specialization, section)
            stud.displayPerson()
        }
        else -> {
            print("test")
        }
    }
}
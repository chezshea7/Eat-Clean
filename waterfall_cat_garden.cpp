/* 
 * Eat Clean:
 * Eating healthy and clean is an important part of living a healthy life. 
 * This code implements a program to help the user make healthier eating choices. 
 */ 

#include <iostream> 
#include <string> 
#include <map> 
#include <vector> 

// Map to store healthy food items and their nutrition values 
std::map<std::string, std::vector<int>> healthyFoods; 

// Function to load healthy foods into the map
void loadHealthyFoods(){ 
    healthyFoods["broccoli"] = {35, 2, 6, 4};
    healthyFoods["salmon"] = {200, 20, 10, 5}; 
    healthyFoods["blueberries"] = {84, 1, 14, 0.7}; 
    healthyFoods["chicken breast"] = {165,31,0,3.5}; 
    healthyFoods["red pepper"] = {24, 0.8, 5, 0.2}; 
    healthyFoods["avocado"] = {322, 29, 16, 15}; 
    healthyFoods["quinoa"] = {222, 8, 39, 6}; 
    healthyFoods["oats"] = {147, 5, 27, 6}; 
    healthyFoods["almonds"] = {578, 21, 7, 49}; 
    healthyFoods["lentils"] = {230, 17, 39, 0.4};
} 

// Function to print the map contents 
void printHealthyFoods(){ 
    for (auto elem : healthyFoods){ 
        std:: cout << elem.first << " : "; 
        for (auto num : elem.second){ 
            std::cout << num << " "; 
        } 
        std::cout << std::endl; 
    } 
} 

// Function to compare the user's input with the map and obtain nutrition information 
void compareFoods(std::string userFood){ 
    if (healthyFoods.find(userFood) == healthyFoods.end())
        std::cout << "Food not found" << std::endl; 
    else{ 
        std::cout << "Calories: " << healthyFoods[userFood][0] << std::endl; 
        std::cout << "Protein: " << healthyFoods[userFood][1] << std::endl; 
        std::cout << "Carbs: " << healthyFoods[userFood][2] << std::endl;
        std::cout << "Fat: " << healthyFoods[userFood][3] << std::endl;
    } 
} 

int main(){ 
    // Load healthy foods into the map 
    loadHealthyFoods(); 

    // Print map contents 
    printHealthyFoods(); 

    // Get user input string 
    std::string food;
    std::cout << "Enter the name of a food: "; 
    std::cin >> food; 

    // Compare food to map 
    compareFoods(food); 

    return 0; 
}
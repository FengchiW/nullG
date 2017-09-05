#include "menu.h"
#include <iostream>

Menu::Menu(float width, float height)
{
	if (!font.loadFromFile("res/Gameplay.ttf")) {
		std::cout << "Error Unable to load font" << std::endl;
	} else { std::cout << "Font loaded" << std::endl; }

	menuI[0].setFont(font);
	menuI[0].setString("NullG");
	menuI[0].setCharacterSize(60);
	menuI[0].setFillColor(sf::Color::White);
	menuI[0].setPosition(sf::Vector2f(width / 4, height / (MAX_NUMBER_OF_ITEMS+1) * 1 - 50));
	std::cout << "Menu Item set"<< std::endl;

	menuI[1].setFont(font);
	menuI[1].setString("Play");
	menuI[1].setCharacterSize(20);
	menuI[1].setFillColor(sf::Color::Red);
	menuI[1].setPosition(sf::Vector2f(width / 3, height / (MAX_NUMBER_OF_ITEMS + 1) * 2 - 10));
	std::cout << "Menu Item set" << std::endl;

	menuI[2].setFont(font);
	menuI[2].setString("Credits");
	menuI[2].setCharacterSize(20);
	menuI[2].setFillColor(sf::Color::White);
	menuI[2].setPosition(sf::Vector2f(width / 3, height / (MAX_NUMBER_OF_ITEMS + 1) * 3 - 10));
	std::cout << "Menu Item set" << std::endl;

	menuI[3].setFont(font);
	menuI[3].setString("Exit / Quit");
	menuI[3].setCharacterSize(20);
	menuI[3].setFillColor(sf::Color::White);
	menuI[3].setPosition(sf::Vector2f(width / 3, height / (MAX_NUMBER_OF_ITEMS + 1) * 4 - 10));
	std::cout << "Menu Item set" << std::endl;

	selectedItemIndex = 1;
}


Menu::~Menu()
{
}

void Menu::draw(sf::RenderWindow &window)
{
	for (int i = 0; i < MAX_NUMBER_OF_ITEMS; i++)
		window.draw(menuI[i]);
}

void Menu::moveUp()
{
	if (selectedItemIndex - 1 >= 1)
	{
		menuI[selectedItemIndex].setFillColor(sf::Color::White);
		selectedItemIndex--;
		menuI[selectedItemIndex].setFillColor(sf::Color::Red);
	}
}
void Menu::moveDown()
{
	if (selectedItemIndex + 2 <= MAX_NUMBER_OF_ITEMS)
	{
		menuI[selectedItemIndex].setFillColor(sf::Color::White);
		selectedItemIndex++;
		menuI[selectedItemIndex].setFillColor(sf::Color::Red);
	}
}
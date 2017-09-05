#pragma once
#include "SFML\Graphics.hpp"

#define MAX_NUMBER_OF_ITEMS 4

class Menu
{
public:
	Menu(float width, float height);
	~Menu();

	void draw(sf::RenderWindow &window);
	void moveUp();
	void moveDown();

	int currentItem() { return selectedItemIndex; }

private:
	int selectedItemIndex;
	sf::Font font;
	sf::Text menuI[MAX_NUMBER_OF_ITEMS];
};


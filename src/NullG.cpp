/*
NullG ~ a game originally developed by Calder White  Currently vr 0.01.06
The original game can be found at https://github.com/CalderWhite/nullG

This is a c++ adaptation made by (Wilson F. Wang).
Due to the original minimalistic design I will also
continue with the minimalistic theme although the game
may be MUCH different compared to the original.
*/
//* Includes *//
#pragma comment(linker, "/SUBSYSTEM:windows /ENTRY:mainCRTStartup")
#include "SFML\Graphics.hpp"
#include "menu.h"
#include "errorHandler.h"
#include <iostream>

//* Main Function *//
/*
This will be your Opening Scene I recommend making it look nice as
possible as it is what most people use to judge good games from bad ones
*/
int main()
{
	//* Console Display *//
	std::cout << "NullG ~ a game originally developed by Calder White  Currently vr 0.01.06" << std::endl;
	std::cout << "The original game can be found at https://github.com/CalderWhite/nullG" << std::endl;
	std::cout << "This is a c++ adaptation made by(Wilson F.Wang). " << std::endl;
	std::cout << "Due to the original minimalistic design I will also continue with the minimalistic theme " << std::endl;
	std::cout << "although the game may be MUCH different compared to the original. " << std::endl;

	//* Create the window *//
	sf::RenderWindow window(sf::VideoMode(500, 500), "NullG", sf::Style::None);

	Menu menu(window.getSize().x, window.getSize().y);
	errorHandler Error;

	//* Main loop *//
	while (window.isOpen())
	{
		//* Event handler *//
		sf::Event e;
		while (window.pollEvent(e))
		{
			//* Events *//
			switch (e.type)
			{
			case sf::Event::KeyPressed:
				std::cout << "Key Pressed" << std::endl;
				switch (e.key.code) {
				case sf::Keyboard::Escape:
					window.close();
					break;
				
				case sf::Keyboard::Up:
					menu.moveUp();
					break;
				
				case sf::Keyboard::Down:
					menu.moveDown();
					break;

				case sf::Keyboard::Return:
					switch (menu.currentItem()) {
					case 1:
						std::cout << "Game is starting......" << std::endl;
						Error.error(404);
						break;
					case 2:
						std::cout << "Credits Page" << std::endl;
						Error.error(404);
						break;
					case 3:
						window.close();
						break;
					}
				}
			}

			//* Render *//
			window.clear(sf::Color::Black);

			menu.draw(window);

			window.display();

		}
	}
}
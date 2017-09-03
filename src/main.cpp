/*
NullG ~ a game originally developed by Calder White
The original game can be found at https://github.com/CalderWhite/nullG

This is a c++ adaptation made by (Wilson F. Wang).
Due to the original minimalistic design I will also
continue with the minimalistic theme although the game
may be MUCH different compared to the original.
*/

//* Includes *//
#include <SFML\Graphics.hpp>

//* Optional ~ However makes writing simple code much easier! *//
using namespace sf;

//* Main Function *//

/*
This will be your Opening Scene I recommend making it look nice as
possible as it is what most people use to judge good games from bad ones
*/
int main()
{

	//* Create the window *//
	RenderWindow window(VideoMode(500, 500), "NullG");


	//* Main loop *//
	while (window.isOpen())
	{

		//* Event handler *//
		Event e;
		while (window.pollEvent(e))
		{
			//* Events *//
			if (e.type == Event::Closed) {
				window.close();
			}

		}

		//* Draw *//

		window.clear();
		window.display();

	}

}
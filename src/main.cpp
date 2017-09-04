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
#include <iostream>

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
	bool isOnMainScene = true;
	//* Fonts and Textures *//

	Font gameplay;
	if (!gameplay.loadFromFile("res/Gameplay.ttf")) {
		//Error
		std::cout << "Error Font not loaded";
	}
	
	// TODO: Add the button texture to the button (Note Remove the outline when implemented)
	/*
	Texture button;
	if (!button.loadFromFile("")){

	}
	*/

	//* Shapes, Sprites, Text *//

	Text title;
	title.setFont(gameplay);
	title.setString("NullG");
	title.setCharacterSize(60);
	title.setFillColor(Color::White);
	title.setPosition(140, 40);

	RectangleShape startBtn(Vector2f(250, 50));
	startBtn.setFillColor(Color::White);
	startBtn.setOutlineThickness(5);
	startBtn.setOutlineColor(Color::Green);
	startBtn.setPosition(Vector2f(125, 150));

	Text startTxt;
	startTxt.setFont(gameplay);
	startTxt.setString("Start");
	startTxt.setCharacterSize(30);
	startTxt.setFillColor(Color::Black);
	startTxt.setPosition(195, 160);

	RectangleShape optionsBtn(Vector2f(250, 50));
	optionsBtn.setFillColor(Color::White);
	optionsBtn.setOutlineThickness(5);
	optionsBtn.setOutlineColor(Color::Green);
	optionsBtn.setPosition(Vector2f(125, 240));

	// TODO: Add the options text

	/*
	Text startTxt;
	startTxt.setFont(gameplay);
	startTxt.setString("Start");
	startTxt.setCharacterSize(30);
	startTxt.setFillColor(Color::Black);
	startTxt.setPosition(195, 160);
	*/

	// TODO: Add the credits button and text

	/*
	RectangleShape startBtn(Vector2f(250, 50));
	startBtn.setFillColor(Color::Black);
	startBtn.setOutlineThickness(5);
	startBtn.setOutlineColor(Color::Green);
	startBtn.setPosition(Vector2f(125, 150));

	Text startTxt;
	startTxt.setFont(gameplay);
	startTxt.setString("Start");
	startTxt.setCharacterSize(30);
	startTxt.setFillColor(Color::Black);
	startTxt.setPosition(195, 160);
	*/

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

		//* Update *//

		/*
		int scalePct = 0;
		do {
			if (scalePct = 0) {
				title.scale(1.5f, 1.5f);
				scalePct++;
			}
			else {
				title.scale(1.0f, 1.0f);
				scalePct--;
			}
		} while (isOnMainScene);
		*/

		//* Render *//

		window.clear(Color::Black);

		window.draw(startBtn);
		window.draw(startTxt);
		window.draw(optionsBtn);
		window.draw(title);

		window.display();


	}

}
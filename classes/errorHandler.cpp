#include "errorHandler.h"
#include <iostream>



errorHandler::errorHandler()
{
}


errorHandler::~errorHandler()
{
}

void errorHandler::error(int errorCode)
{
	switch (errorCode)
	{
	case 404:
		std::cout << "ERROR 404 NOT FOUND \n Sorry but looks like the game is not ready yet and this portal dosn't exist." << std::endl;
	case 501:
		std::cout << "ERROR 501 NOT IMPLEMENTED \n This part is made however, its not ready for the public yet sorry!" << std::endl;
	default:
		std::cout << "ERROR What?!?! \n Sorry but it looks like this error dosn't exist umm... How did you manage to get it!?" << std::endl;
	}
}

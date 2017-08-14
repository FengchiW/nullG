package nullG;

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    
	class ForeGround{
        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE
    
        // BRIGHT
        public static final String BLACK_BRIGHT = "\033[1;30m";  // BLACK
        public static final String RED_BRIGHT = "\033[1;31m";    // RED
        public static final String GREEN_BRIGHT = "\033[1;32m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[1;33m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[1;34m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[1;35m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[1;36m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[1;37m";  // WHITE
    
        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
	}
	
	class Background{
	    // Background
	    public static final String BLACK = "\033[40m";  // BLACK
	    public static final String RED = "\033[41m";    // RED
	    public static final String GREEN = "\033[42m";  // GREEN
	    public static final String YELLOW = "\033[43m"; // YELLOW
	    public static final String BLUE = "\033[44m";   // BLUE
	    public static final String PURPLE = "\033[45m"; // PURPLE
	    public static final String CYAN = "\033[46m";   // CYAN
	    public static final String WHITE = "\033[47m";  // WHITE
	
	    // High Intensity backgrounds
	    public static final String BLACK_BRIGHT = "\033[0;100m";// BLACK
	    public static final String RED_BRIGHT = "\033[0;101m";// RED
	    public static final String GREEN_BRIGHT = "\033[0;102m";// GREEN
	    public static final String YELLOW_BRIGHT = "\033[0;103m";// YELLOW
	    public static final String BLUE_BRIGHT = "\033[0;104m";// BLUE
	    public static final String PURPLE_BRIGHT = "\033[0;105m"; // PURPLE
	    public static final String CYAN_BRIGHT = "\033[0;106m";  // CYAN
	    public static final String WHITE_BRIGHT = "\033[0;107m";   // WHITE
	}
}
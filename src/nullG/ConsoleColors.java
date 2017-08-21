package nullG;

import java.util.HashMap;
import java.util.Map;

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    
    public static final Map<String,Byte> toNum = new HashMap<String,Byte>() {{
        put("\033[0;30m",(byte)   1);
        put("\033[0;31m",(byte)   2);
        put("\033[0;32m",(byte)   3);
        put("\033[0;33m",(byte)   4);
        put("\033[0;34m",(byte)   5);
        put("\033[0;35m",(byte)   6);
        put("\033[0;36m",(byte)   7);
        put("\033[0;37m",(byte)   8);
        put("\033[1;30m",(byte)   9);
        put("\033[1;31m",(byte)  10);
        put("\033[1;32m",(byte)  11);
        put("\033[1;33m",(byte)  12);
        put("\033[1;34m",(byte)  13);
        put("\033[1;35m",(byte)  14);
        put("\033[1;36m",(byte)  15);
        put("\033[1;37m",(byte)  16);
        put("\033[4;30m",(byte)  17);
        put("\033[4;31m",(byte)  18);
        put("\033[4;32m",(byte)  19);
        put("\033[4;33m",(byte)  20);
        put("\033[4;34m",(byte)  21);
        put("\033[4;35m",(byte)  22);
        put("\033[4;36m",(byte)  23);
        put("\033[4;37m",(byte)  24);
        put("\033[40m",(byte)    25);
        put("\033[41m",(byte)    26);
        put("\033[42m",(byte)    27);
        put("\033[43m",(byte)    28);
        put("\033[44m",(byte)    29);
        put("\033[45m",(byte)    30);
        put("\033[46m",(byte)    31);
        put("\033[47m",(byte)    32);
        put("\033[0;101m",(byte) 32);
        put("\033[0;102m",(byte) 33);
        put("\033[0;103m",(byte) 34);
        put("\033[0;104m",(byte) 35);
        put("\033[0;105m",(byte) 36);
        put("\033[0;106m",(byte) 37);
        put("\033[0;107m",(byte) 38);
    }};
    
    public static String[] numToString = {
        "",         // because I screwed up
        "\033[0;30m",
        "\033[0;31m",
        "\033[0;32m",
        "\033[0;33m",
        "\033[0;34m",
        "\033[0;35m",
        "\033[0;36m",
        "\033[0;37m",
        "\033[1;30m",
        "\033[1;31m",
        "\033[1;32m",
        "\033[1;33m",
        "\033[1;34m",
        "\033[1;35m",
        "\033[1;36m",
        "\033[1;37m",
        "\033[4;30m",
        "\033[4;31m",
        "\033[4;32m",
        "\033[4;33m",
        "\033[4;34m",
        "\033[4;35m",
        "\033[4;36m",
        "\033[4;37m",
        "\033[40m",
        "\033[41m",
        "\033[42m",
        "\033[43m",
        "\033[44m",
        "\033[45m",
        "\033[46m",
        "\033[47m",
        "\033[0;101m",
        "\033[0;102m",
        "\033[0;103m",
        "\033[0;104m",
        "\033[0;105m",
        "\033[0;106m",
        "\033[0;107m"
    };
    
	class ForeGround{
        // Regular Colors
        public static final String BLACK =  "\033[0;30m";   // BLACK
        public static final String RED =    "\033[0;31m";     // RED
        public static final String GREEN =  "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE =   "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN =   "\033[0;36m";    // CYAN
        public static final String WHITE =  "\033[0;37m";   // WHITE
    
        // BRIGHT
        public static final String BLACK_BRIGHT =  "\033[1;30m";  // BLACK
        public static final String RED_BRIGHT =    "\033[1;31m";    // RED
        public static final String GREEN_BRIGHT =  "\033[1;32m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[1;33m"; // YELLOW
        public static final String BLUE_BRIGHT =   "\033[1;34m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[1;35m"; // PURPLE
        public static final String CYAN_BRIGHT =   "\033[1;36m";   // CYAN
        public static final String WHITE_BRIGHT =  "\033[1;37m";  // WHITE
    
        // Underline
        public static final String BLACK_UNDERLINED =  "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED =    "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED =  "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED =   "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED =   "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED =  "\033[4;37m";  // WHITE
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
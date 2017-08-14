def main():
    name = input("Please input your name for sanghooh-san:")
    print("Hello %s-senpai. pls bang." % name)
    def ask():
        a = input("Y/N?:")
        if a.lower() == 'y':
            return True
        elif a.lower() == 'n':
            return False
        else:
            print("ur dumb")
            return ask()
    a = ask()
    if a:
        print("*bed shaking noises*")
    else:
        print("sanghooh-san mopes.")
        
main()
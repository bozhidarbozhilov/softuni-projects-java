using System;

namespace p13_Vowel_Or_Digit
{
    class Vowel_Or_Digit
    {
        static void Main(string[] args)
        {
            string inputChar = Console.ReadLine();

            if(int.TryParse(inputChar, out int digit))
            {
                Console.WriteLine("digit");
            }
            else
            {
                switch (inputChar)
                {
                    case "a":
                    case "e":
                    case "y":
                    case "i":
                    case "o":
                    case "u":
                        Console.WriteLine("vowel");
                        break;
                    default:
                        Console.WriteLine("other");
                        break;
                }
            }
        }
    }
}

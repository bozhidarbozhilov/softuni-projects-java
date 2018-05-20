using System;

namespace p14_MagicLetter
{
    class MagicLetter
    {
        static void Main(string[] args)
        {
            char firstChar = char.Parse(Console.ReadLine());
            char secondChar = char.Parse(Console.ReadLine());
            char magicChar = char.Parse(Console.ReadLine());

            for (char a = firstChar; a <= secondChar; a++)
            {
                for (char b = firstChar; b <= secondChar; b++)
                {
                    for (char c = firstChar; c <= secondChar; c++)
                    {
                        if(a != magicChar && b != magicChar && c != magicChar)
                        {
                            Console.Write($"{a}{b}{c} ");
                        }
                    }
                }
            }
            Console.WriteLine();
        }
    }
}

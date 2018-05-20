using System;

namespace p06_Strings_and_Objects
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstString = "Hello";
            string secondString = "World";
            object wholeString = firstString +" "+ secondString;

            Console.WriteLine(wholeString);
        }
    }
}

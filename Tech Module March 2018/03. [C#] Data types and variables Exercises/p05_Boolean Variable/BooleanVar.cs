using System;

namespace p05_Boolean_Variable
{
    class BooleanVar
    {
        static void Main(string[] args)
        {
            string booleanVar = Console.ReadLine();

            if (Convert.ToBoolean(booleanVar))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
            
        }
    }
}

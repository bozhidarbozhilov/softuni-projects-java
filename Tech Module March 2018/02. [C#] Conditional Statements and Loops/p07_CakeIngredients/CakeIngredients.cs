using System;

namespace p07_CakeIngredients
{
    class CakeIngredients
    {
        static void Main(string[] args)
        {
            int counter = 0;
            string ingredient = Console.ReadLine();

            while (!ingredient.Equals("Bake!"))
            {
                Console.WriteLine($"Adding ingredient {ingredient}.");
                counter++;
                ingredient = Console.ReadLine(); 
            }

            Console.WriteLine($"Preparing cake with {counter} ingredients.");
        }
    }
}

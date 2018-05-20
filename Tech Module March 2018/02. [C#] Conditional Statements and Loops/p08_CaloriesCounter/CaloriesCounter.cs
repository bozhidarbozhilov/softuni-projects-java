using System;

namespace p08_CaloriesCounter
{
    class CaloriesCounter
    {
        static void Main(string[] args)
        {
            int cheeseCals = 500;
            int tomatoSauceCals = 150;
            int salamiCals = 600;
            int pepperCals = 50;

            int caloriesSum = 0;

            int productsCount = int.Parse(Console.ReadLine());

            for (int i = 0; i < productsCount; i++)
            {
                string product = Console.ReadLine().ToLower();

                switch (product)
                {
                    case "cheese":
                        caloriesSum += cheeseCals;
                        break;
                    case "tomato sauce":
                        caloriesSum += tomatoSauceCals;
                        break;
                    case "salami":
                        caloriesSum += salamiCals;
                        break;
                    case "pepper":
                        caloriesSum += pepperCals;
                        break;
                    default:
                        break;
                }
            }
            Console.WriteLine($"Total calories: {caloriesSum}");
        }
    }
}

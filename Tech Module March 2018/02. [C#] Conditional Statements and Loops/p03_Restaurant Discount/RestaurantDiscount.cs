using System;

namespace p03_Restaurant_Discount
{
    class RestaurantDiscount
    {
        static void Main(string[] args)
        {
            int people = int.Parse(Console.ReadLine());
            string package = Console.ReadLine();

            int hallPrice = 0;
            int packagePrice = 0;
            double discount = 0.0;
            double endPrice = 0.0;
            string hallName = "";

            if(people > 0 && people <= 50)
            {
                hallPrice = 2500;
                hallName = "Small Hall";
                switch (package)
                {
                    case "Normal":
                        packagePrice = 500;
                        discount = 0.05;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Gold":
                        packagePrice = 750;
                        discount = 0.1;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Platinum":
                        packagePrice = 1000;
                        discount = 0.15;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                }
                Console.WriteLine($"We can offer you the {hallName}");
                Console.WriteLine($"The price per person is {endPrice / people:F2}$");
            }
            else if(people > 50 && people <= 100)
            {
                hallPrice = 5000;
                hallName = "Terrace";
                switch (package)
                {
                    case "Normal":
                        packagePrice = 500;
                        discount = 0.05;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Gold":
                        packagePrice = 750;
                        discount = 0.1;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Platinum":
                        packagePrice = 1000;
                        discount = 0.15;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                }
                Console.WriteLine($"We can offer you the {hallName}");
                Console.WriteLine($"The price per person is {endPrice / people:F2}$");
            }
            else if (people > 100 && people <= 120)
            {
                hallPrice = 7500;
                hallName = "Great Hall";
                switch (package)
                {
                    case "Normal":
                        packagePrice = 500;
                        discount = 0.05;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Gold":
                        packagePrice = 750;
                        discount = 0.1;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                    case "Platinum":
                        packagePrice = 1000;
                        discount = 0.15;
                        endPrice = (hallPrice + packagePrice) - ((hallPrice + packagePrice) * discount);
                        break;
                }
                Console.WriteLine($"We can offer you the {hallName}");
                Console.WriteLine($"The price per person is {endPrice/people:F2}$");
            }
            else
            {
                Console.WriteLine("We do not have an appropriate hall.");
            }
        }
    }
}

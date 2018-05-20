using System;

namespace p04_Hotel
{
    class Hotel
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());
            double studioPrice = 0.0;
            double doublePrice = 0.0;
            double suitePrice = 0.0;
            double studioDiscount = 0.0;
            double doubleDiscount = 0.0;
            double suiteDiscount = 0.0;

            switch (month)
            {
                case "May":
                case "October":
                 
                    if (nights > 7)
                    {
                        studioDiscount = 50 * 0.95;
                        studioPrice = nights * studioDiscount;
                        if (month.Equals("October"))
                        {
                            studioPrice = studioPrice - 50*0.95;
                        }
                    
                    }
                    else
                    {
                        studioPrice = nights * 50;
                    }

                 
                    doublePrice = nights * 65;
                    suitePrice = nights * 75;
                    break;

                case "June":
                case "September":
 
                    if (nights > 14)
                    {
                        doubleDiscount = 72 * 0.9;
                        doublePrice = nights * doubleDiscount;
                    }
                    else
                    {
                        doublePrice = nights * 72;
                    }
                    if (nights > 7 && month.Equals("September"))
                    {
                        studioPrice = (nights-1) * 60;
                    }
                    else
                    {
                        studioPrice = nights * 60;
                    }

                    
                    suitePrice = nights * 82;
                    break;
                case "July":
                case "August":
                case "December":
                    if (nights > 14)
                    {
                        suiteDiscount = 89 * 0.85;
                        suitePrice = nights * suiteDiscount;
                    }
                    else
                    {
                        suitePrice = nights * 89;
                    }
                    studioPrice = nights * 68;
                    doublePrice = nights * 77;
                    break;
                default:
                    break;
            }

 
            Console.WriteLine($"Studio: {studioPrice:F2} lv.");
            Console.WriteLine($"Double: {doublePrice:F2} lv.");
            Console.WriteLine($"Suite: {suitePrice:F2} lv.");

        }
    }
}

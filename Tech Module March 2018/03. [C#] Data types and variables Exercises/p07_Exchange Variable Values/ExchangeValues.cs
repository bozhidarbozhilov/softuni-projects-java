using System;

namespace p07_Exchange_Variable_Values
{
    class ExchangeValues
    {
        static void Main(string[] args)
        {
            int a = 5;
            int b = 10;

            Console.WriteLine("Before:"+"\r\n"+ $"a = {a}" +"\r\n"+$"b = {b}");

            int temp = a;
            a = b;
            b = temp;

            Console.WriteLine("After:" + "\r\n" + $"a = {a}" + "\r\n" + $"b = {b}");

        }
    }
}

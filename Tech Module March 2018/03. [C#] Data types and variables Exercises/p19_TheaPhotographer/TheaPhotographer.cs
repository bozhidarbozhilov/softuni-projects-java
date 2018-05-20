using System;

namespace p19_TheaPhotographer
{
    class TheaPhotographer
    {
        static void Main(string[] args)
        {
            long totalPictures = int.Parse(Console.ReadLine());
            int filterTime = int.Parse(Console.ReadLine());
            int filterFactor = int.Parse(Console.ReadLine());
            int uploadTime = int.Parse(Console.ReadLine());

            long totalFilterTime = totalPictures * filterTime;
            decimal remainPictures = totalPictures*(decimal)(filterFactor/100.0);
            long temp = (int)Math.Ceiling(remainPictures);
            long uploadTotalTime = temp * uploadTime;
            long totalTime = totalFilterTime + uploadTotalTime;

            long seconds = totalTime % 60;
            long minutes = (totalTime / 60) % 60;
            long hours =(totalTime / 60 / 60) % 24;
            long days = (totalTime / 60 / 60 / 24);

            Console.WriteLine($"{days}:{hours:D02}:{minutes:D02}:{seconds:D02}");

        }
    }
}

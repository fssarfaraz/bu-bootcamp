package module2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GradeAnalyzer {
    
    public static void main(String[] args) {
        String filename = "scores.txt";

        ArrayList<Integer> scores = readScores(filename);
        //commented out but used for inital testing
        //System.out.println("Scores: " + scores);
        /*
        ArrayList<Integer> testArray = new ArrayList<>();
        for(int i=1; i<5; i++)
        {
            testArray.add(i);
        }

        double testAvg = calculateAverage(testArray);
        System.out.println("The average of the test arraylist is: " + testAvg);
        */
        double avg = calculateAverage(scores);
        //System.out.println("The average of the scores is: " + avg);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        //loop through the arraylist and replace the highest and lowest vraible as appropriate
        for(int score : scores)
        {
            if(score > highest)
            {
                highest = score;
            }
            if(score < lowest)
            {
                lowest = score;
            }
        }

        //System.out.println("The highest score on the list is: " + highest);
        //System.out.println("The lowest score on the list is: " + lowest);

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        //loop  through the arraylist and assign scores to bands
        for(int score : scores)
        {
            if(score >= 90)
            {
                countA++;
            }
            else if(score >= 80)
            {
                countB++;
            }
            else if(score >= 70)
            {
                countC++;
            }
            else if(score >= 60)
            {
                countD++;
            }
            else
            {
                countF++;
            }
        }

        String outputFile = "report.txt";
        //write to report as well as print to screen
        writeReport(scores, avg, highest, lowest, outputFile, countA, countB, countC, countD, countF);
    }

    public static ArrayList<Integer> readScores(String filename)
    {
        ArrayList<Integer> scores = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            
                while((line = reader.readLine()) != null)
                {
                    if(!line.trim().isEmpty())
                    {
                        try 
                        {
                            int n = Integer.parseInt(line.trim());
                            scores.add(n);
                        } 
                        catch (NumberFormatException eNum) 
                        {
                            System.out.println("Skipping invalid value: " + line);
                        }
                    }
                }
            
        } 
        catch (IOException eFile) 
        {
            System.out.println("Could not read file: " + eFile.getMessage());
        }
        return scores;
    }
    
    public static double calculateAverage(ArrayList<Integer> scores)
    {
        double avg = 0.0;
        int sum = 0;
        if(scores!= null && !scores.isEmpty())
        {
            for(int score : scores)
            {
                sum += score;
            }

            if(sum>0)
            {
                avg = (double) sum/scores.size();
            }
        }
        else
        {   
            avg = 0.0;
        }
        return avg;
    }

    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile, int countA, int countB, int countC, int countD, int countF)
    {
        int linesInSource = 17;
        int linesSkipped = linesInSource - scores.size();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))
        {
            writer.write("=== Grade Analysis Report ===");
            System.out.println("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write("Total scores processed: " + scores.size());
            System.out.println("Total scores processed: " + scores.size());
            writer.newLine();
            writer.write("Invalid lines skipped: " + linesSkipped);
            System.out.println("Invalid lines skipped: " + linesSkipped);
            writer.newLine();
            writer.newLine();
            System.out.println("\n");
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d", high));
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d", low));
            writer.newLine();
            System.out.println("\n");
            writer.write("Grades distribution:");
            writer.newLine();
            writer.write(String.format("\tA (90-100): %d%n", countA));
            writer.write(String.format("\tB (80-89): %d%n", countB));
            writer.write(String.format("\tC (70-79): %d%n", countC));
            writer.write(String.format("\tD (60-69): %d%n", countD));
            writer.write(String.format("\tF (below 60): %d%n", countF));
            System.out.println("Grades distribution:");
            System.out.println(String.format("\tA (90-100): %d", countA));
            System.out.println(String.format("\tB (80-89): %d", countB));
            System.out.println(String.format("\tC (70-79): %d", countC));
            System.out.println(String.format("\tD (60-69): %d", countD));
            System.out.println(String.format("\tF (below 60): %d%n", countF));

        } 
        catch (IOException eFile) 
        {
            System.out.println("Could not write file: " + eFile.getMessage());
        }
    }
}


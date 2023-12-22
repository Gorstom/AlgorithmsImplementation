import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static int randomNumberGenerator(int range,int bound){
        int number, number2, number3, result=0;
        int flip;
        Random random = new Random();
        int range_mod=random.nextInt(1,bound+1);
        number = random.nextInt(1, range+range_mod+1);
        number2 = random.nextInt(1, range+range_mod+1);
        number3 = random.nextInt(1, range+range_mod+1);
        flip = random.nextInt(1,3);
        if(flip==1) result=number+number2+number3;
        else if(flip==0 && number>number2)  result=number-number2+number3;

        if(result<=0) return randomNumberGenerator(range,bound);
        return result;
    }
    public static void main(String[] args) {
        String fileName = "output.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        List smallList = new List();
        List mediumList = new List();
        List hugeList = new List();
        BidirectionalList smallBilist = new BidirectionalList();
        BidirectionalList mediumBilist = new BidirectionalList();
        BidirectionalList hugeBilist = new BidirectionalList();
        BinaryTree smallTree = new BinaryTree();
        BinaryTree mediumTree = new BinaryTree();
        BinaryTree hugeTree = new BinaryTree();
        int number;


//filling---------------------------------------------
            int small_range=20, medium_range=300, huge_range=18000;
            int small_range_mod=25, medium_range_mod=190, huge_range_mod=97000;
            int [] small_size_structure=new int[20], medium_size_structure=new int[200], huge_size_structure=new int[100000];




        for (int i = 0; i < small_size_structure.length; i++) {
            small_size_structure[i]=randomNumberGenerator(small_range,small_range_mod);
        }

        for (int i = 0; i < medium_size_structure.length; i++) {
            medium_size_structure[i]=randomNumberGenerator(medium_range,medium_range_mod);
        }

        for (int i = 0; i < huge_size_structure.length; i++) {
            huge_size_structure[i]=randomNumberGenerator(huge_range,huge_range_mod);
        }

            long startTime;
            long endTime;
            long timeElapsed;
//small filling
        startTime = System.nanoTime();
        for(int i=0; i<small_size_structure.length; i++){
            smallList.add(small_size_structure[i]);

        }
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
        bufferedWriter.append(timeElapsed + ",");


        startTime = System.nanoTime();
        for(int i=0; i<small_size_structure.length; i++) {
            smallBilist.add(small_size_structure[i]);
        }

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
        bufferedWriter.append(timeElapsed + ",");


        startTime = System.nanoTime();
        for(int i=0; i<small_size_structure.length; i++) {
                smallTree.treeInsert(small_size_structure[i]);
            }

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
// medium filling
            startTime = System.nanoTime();
            for(int i=0; i<medium_size_structure.length; i++) {
               mediumList.add(medium_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            for(int i=0; i<medium_size_structure.length; i++) {
                mediumBilist.add(medium_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");




            startTime = System.nanoTime();
            for(int i=0; i<medium_size_structure.length; i++) {
                mediumTree.treeInsert(medium_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");



            //huge filling ----
            startTime = System.nanoTime();
            for(int i=0; i<huge_size_structure.length; i++) {
                hugeList.add(huge_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            for(int i=0; i<huge_size_structure.length; i++) {
                hugeBilist.add(huge_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");




            startTime = System.nanoTime();
            for(int i=0; i<huge_size_structure.length; i++) {
                hugeTree.treeInsert(huge_size_structure[i]);
            }

            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
//printing---------------------------------------------
            startTime = System.nanoTime();
            smallList.print();
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("-----------");


            startTime = System.nanoTime();
            smallBilist.print();
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;

            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("-----------");

            startTime = System.nanoTime();
            smallTree.inorderTreeWalk(smallTree.root);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("-----------");
//searching---------------------------------------------
            number = randomNumberGenerator(small_range,small_range_mod);
            int number2 = randomNumberGenerator(medium_range,medium_range_mod);
            int number3 = randomNumberGenerator(huge_range,huge_range_mod);
            System.out.println("drawn small number: "+number);
            System.out.println("drawn medium number: "+number2);
            System.out.println("drawn huge number: "+number3);
        //search in list
            startTime = System.nanoTime();
            System.out.println("index of given number: "+smallList.getIndex(number));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("index of given number: "+mediumList.getIndex(number2));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("index of given number: "+hugeList.getIndex(number3));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

        //search in bilist
            startTime = System.nanoTime();
            System.out.println("index of given number: "+smallBilist.getIndex(number));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("index of given number: "+mediumBilist.getIndex(number2));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("index of given number: "+hugeBilist.getIndex(number3));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

        //search in tree
            startTime = System.nanoTime();
            System.out.println("search in tree: "+smallTree.iterativeTreeSearch(smallTree.root,number));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("search in tree: "+mediumTree.iterativeTreeSearch(mediumTree.root,number2));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("search in tree: "+hugeTree.iterativeTreeSearch(hugeTree.root,number3));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

//deleting----------------------------------------------
            number = randomNumberGenerator(small_range,small_range_mod);
            System.out.println("drawn number: "+number);

            //delete from list
            number = randomNumberGenerator(small_range,small_range_mod);
            int temp = smallList.getIndex(number);
            startTime = System.nanoTime();
            smallList.deleteAt(temp);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            number = randomNumberGenerator(medium_range,medium_range_mod);
            temp = mediumList.getIndex(number);
            startTime = System.nanoTime();
            mediumList.deleteAt(temp);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            //delete from bidirectional list
            number = randomNumberGenerator(medium_range,medium_range_mod);
            temp = hugeBilist.getIndex(number);
            startTime = System.nanoTime();
            hugeBilist.deleteAt(temp);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
        //delete from tree


            number = randomNumberGenerator(small_range,small_range_mod);
            ElementBT element = new ElementBT(number);

            if(element.value==null) System.out.println("Error - value has not been given.");
            else{
            startTime = System.nanoTime();
            smallTree.treeDelete(element.value);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            number = randomNumberGenerator(medium_range,medium_range_mod);
            element = new ElementBT(number);

            if(element.value==null) System.out.println("Error - value has not been given.");
            else{
                startTime = System.nanoTime();
                mediumTree.treeDelete(element.value);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            number = randomNumberGenerator(huge_range,huge_range_mod);
            element = new ElementBT(number);

            if(element.value==null) System.out.println("Error - value has not been given.");
            else{
                startTime = System.nanoTime();
                hugeTree.treeDelete(element.value);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


//finding maximum----------------------------------------------
            int max=smallList.getValue(0);
            startTime = System.nanoTime();
            for(int i=0; i < smallList.length; i++){
                if(smallList.getValue(i)>max)
                    max=smallList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            System.out.println("Maximum in small list:"+max);

            max=mediumList.getValue(0);
            startTime = System.nanoTime();
            for(int i=0; i < mediumList.length; i++){
                if(mediumList.getValue(i)>max)
                    max=mediumList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            System.out.println("Maximum in medium list:"+max);
            //-------
            max=hugeList.getValue(0);
            startTime = System.nanoTime();
            for(int i=0; i < hugeList.length; i++){
                if(hugeList.getValue(i)>max)
                    max=hugeList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            System.out.println("Maximum in huge list:"+max);

//            System.out.println("small tree:");
//            smallTree.inorderTreeWalk(smallTree.root);

            startTime = System.nanoTime();
            System.out.println("Maximum in small tree:"+smallTree.treeMaximum(smallTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

//            System.out.println("medium tree:");
//            mediumTree.inorderTreeWalk(mediumTree.root);

            startTime = System.nanoTime();
            System.out.println("Maximum in medium tree:"+mediumTree.treeMaximum(mediumTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            System.out.println("Maximum in huge tree:"+hugeTree.treeMaximum(hugeTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

//finding minimum----------------------------------------------
            int min=smallList.getValue(0);
            startTime = System.nanoTime();
            for(int i=0; i < smallList.length; i++){
                if(smallList.getValue(i)<min)
                    min=smallList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("Minimum in small list:"+min);

            startTime = System.nanoTime();
            for(int i=0; i < mediumList.length; i++){
                if(mediumList.getValue(i)<min)
                    min=mediumList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("Minimum in medium list:"+min);



            startTime = System.nanoTime();
            for(int i=0; i < hugeList.length; i++){
                if(hugeList.getValue(i)<min)
                    min=hugeList.getValue(i);
            }
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            System.out.println("Minimum in huge list:"+min);

            startTime = System.nanoTime();
            System.out.println("Minimum in small tree:"+smallTree.treeMinimum(smallTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");
            startTime = System.nanoTime();
            System.out.println("Minimum in medium tree:"+mediumTree.treeMinimum(mediumTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            startTime = System.nanoTime();
            System.out.println("Minimum in huge tree:"+hugeTree.treeMinimum(hugeTree.root));
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");


            String stringValue = String.valueOf(timeElapsed);
            bufferedWriter.append(stringValue);

            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


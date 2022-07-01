package com.example.test


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*


class MainActivity : AppCompatActivity() {

//    1.დაწერეთ ფუნქცია, რომელსაც გადაეცემა ტექსტი  და აბრუნებს პალინდრომია თუ არა.
//    (პალინდრომი არის ტექსტი რომელიც ერთნაირად იკითხება ორივე მხრიდან).
//    Boolean isPalindrome(String text);

    fun isPalindrome(text:String) : Boolean{
        return text == text.reversed()

    }


//    2.     გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა თანხა (თეთრებში)
//    და აბრუნებს მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.
//    Int minSplit(Int amount);

    fun minSplit(amount: Int) : Int{
        val list = listOf(50,20,10,5,1)
        var count = 0
        var value = amount

        for(i in 0..4){
            while(value >= list[i]){
                value -= list[i]
                count++
            }
            if(value == 0) break
        }
        return count
    }

//    3.     მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც გადაეცემა ეს მასივი
//    და აბრუნებს მინიმალურ მთელ რიცხვს, რომელიც 0-ზე მეტია და ამ მასივში არ შედის.
//    Int notContains(Int[] array);


    fun notContains(array :Array<Int>) : Int{

        array.sort()

        val size = array.size
        var low = 0
        var high = size - 1
        var result = 1

        while(low <= high){
            val mid = (low + high) / 2

            if(array[mid] <= result){
                if(array[mid] == result){
                    result += 1
                    high = size - 1
                }
                low = mid + 1
            }
            else high = mid - 1

        }
        return result
    }

//    4.     მოცემულია String რომელიც შედგება „(„ და „)“ ელემენტებისგან. დაწერეთ ფუნქცია რომელიც
//    აბრუნებს ფრჩხილები არის თუ არა მათემატიკურად სწორად დასმული.
//    Boolean isProperly(String sequence);

    fun isProperly(sequence: String) : Boolean{

        var isBalanced = true
        var count = 0

        for(i in 0..sequence.length-1){
            if(sequence[i] == '('){
                count++
            }
            else count--

            if(count<0){
                isBalanced = false
                break
            }
        }
        if(count!=0){
            isBalanced = false
        }
        return isBalanced
    }

//    5.     გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით.
//    დაწერეთ ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.
//    Int countVariants(Int stearsCount);

    fun countVariants(stearsCount: Int): Int{

        if (stearsCount <= 1){
            return stearsCount
        }
        return countVariants(stearsCount - 1) + countVariants(stearsCount - 2)
    }
// passParameter ფუნქციას უნდა გადავცეთ კიბის სართულების რაოდენობა(n), რომლისთვისაც გვინდა ასვლის ვარიანტების დათვლა, რადგან
// countVariants რეკურსიულ ფუნქციას უნდა გადაეცეს საფეხურების რაოდენობაზე 1-ით მეტი (n+1), რომ სწორად დათვალოს ვარიანტების რაოდენობა
    fun passParameter(stearsCount: Int): Int{
        return countVariants(stearsCount + 1)
    }


//    6.     დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში წავშალოთ ელემენტი.

    fun remove(element: Int){
        val array:MutableList<Int> = mutableListOf(1,2,3)
        val index = array.indexOf(element)
        val size = array.size

        if (index == -1) return

        Collections.swap(array, index, size-1)
        array.removeAt(size-1)

    }


}
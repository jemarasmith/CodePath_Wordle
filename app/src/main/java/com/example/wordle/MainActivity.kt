package com.example.wordle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.R.id.textInputEditText4


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      FourLetterWordList.getAllFourLetterWords()

      var guesses = 0
      val enterbutton = findViewById<Button>(R.id.button)
      val textView = findViewById<TextView>(R.id.answer)

      val answer = findViewById<TextView>(R.id.answer)
      val seek: String = FourLetterWordList.getRandomFourLetterWord()
      answer.text = seek

      fun checkAnswer(answer: String): String {
        var result = ""
        for (i in 0..3) {
          if (answer[i] == seek[i]) {
            result += "O"
          } else if (answer[i] in seek) {
            result += "+"
          } else {
            result += "X"
          }
        }
        return result
      }

      enterbutton.setOnClickListener {
        // Get the input from the input layout.
        val userInput = findViewById<EditText>(textInputEditText4)


        if (guesses == 0) {
          val guess1 = findViewById<TextView>(R.id.userguess1)
          val guess1Hint = findViewById<TextView>(R.id.userguess1hint)
          guess1.text = userInput.text.toString()
          val toCheck1 = guess1.text.toString().uppercase()
          val guess1answer = checkAnswer(toCheck1)
          guess1Hint.text = guess1answer
          guesses++
          if (guess1Hint.text == "OOOO") {
            Toast.makeText(this, "$seek", Toast.LENGTH_LONG).show()
            answer.visibility = View.VISIBLE
            textView.text = findViewById<TextView>(R.id.answer).toString()

          }
        } else if (guesses == 1) {
          val guess2 = findViewById<TextView>(R.id.userguess2)
          val guess2Hint = findViewById<TextView>(R.id.userguess2hint)
          guess2.text = userInput.text.toString()
          val toCheck2 = guess2.text.toString().uppercase()
          val guess2answer = checkAnswer(toCheck2)
          guess2Hint.text = guess2answer
          guesses++
          if (guess2Hint.text == "OOOO") {
            Toast.makeText(this, "$seek", Toast.LENGTH_LONG).show()
            answer.visibility = View.VISIBLE
            textView.text = findViewById<TextView>(R.id.answer).toString()

          }
        } else if (guesses == 2) {
          val guess3 = findViewById<TextView>(R.id.userguess3)
          val guess3Hint = findViewById<TextView>(R.id.userguess3hint)
          guess3.text = userInput.text.toString()
          val toCheck3 = guess3.text.toString().uppercase()
          val guess3answer = checkAnswer(toCheck3)
          guess3Hint.text = guess3answer
          guesses++
          if (guess3Hint.text == "OOOO") {
            Toast.makeText(this, "$seek", Toast.LENGTH_LONG).show()
            answer.visibility = View.VISIBLE
            textView.text = findViewById<TextView>(R.id.answer).toString()
          } else {
            Toast.makeText(this, "$seek", Toast.LENGTH_LONG).show()
            answer.visibility = View.VISIBLE
            if (guesses == 3){
              enterbutton.isEnabled = false
              Toast.makeText(this, "You've exceeded your number of tries", Toast.LENGTH_SHORT).show()
              answer.visibility = View.VISIBLE
              enterbutton.setOnClickListener {
                textView.text = findViewById<TextView>(R.id.answer).toString()
              }
            }
//            enterbutton.setOnClickListener {
//              textView.text = findViewById<TextView>(R.id.answer).toString()
            }
          }
        }
//        else if (guesses == 3){
//            enterbutton.isEnabled = false
//            Toast.makeText(this, "You've exceeded your number of tries", Toast.LENGTH_SHORT).show()
//            answer.visibility = View.VISIBLE
//          enterbutton.setOnClickListener {
//            textView.text = findViewById<TextView>(R.id.answer).toString()
//          }
//        }
      }
        }

      //}

      // author: calren
      object FourLetterWordList {
        // List of most common 4 letter words from: https://7esl.com/4-letter-words/
        val fourLetterWords =
          "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club," +
            "Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food," +
            "Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour," +
            "Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary," +
            "Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play," +
            "Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side," +
            "Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn," +
            "Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat," +
            "Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail," +
            "Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold," +
            "Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose," +
            "Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray," +
            "Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed," +
            "Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary," +
            "View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue," +
            "Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair," +
            "Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy," +
            "Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere," +
            "Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real," +
            "Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny," +
            "Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away," +
            "Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here," +
            "High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part," +
            "Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
          return fourLetterWords.split(",")
        }

        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
          val allWords = getAllFourLetterWords()
          val randomNumber = (0..allWords.size).shuffled().last()
          return allWords[randomNumber].uppercase()
        }
      }




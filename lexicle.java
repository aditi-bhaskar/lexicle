import java.util.* ;
// Written by Aditi B
// spin-off of wordle
class Main {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in) ;
    boolean is_play_over = false ;
    boolean is_game_over = false ;

    System.out.println("\nPLAYING LEXICLE \n\n") ; 

    System.out.println(".................................... \n" +
                        "How to play:\n" +
                        "enter a starting word," +
                        "then repeatedly enter more words\n" +
                        "until you guess the right word entirely\n" +
                        "  *letter means letter is not in the word\n" +
                        "  +letter means letter is in word, wrong spot\n" +
                        "  letter (by itself) means letter is in word, right spot\n" +
                        "good luck!\n ***** \n") ;
    
    //initializing options to play with
    ArrayList<String> ans = new ArrayList<String>();
    ans.add("TRIAL") ;

    //other initializations
    ArrayList<String> past_guesses = new ArrayList<String>() ;
    int guess_count = 0 ;

    //and, now to the game
    while(!is_play_over) {
        
      is_game_over = false ;

      // player action...
      System.out.print("Would you like to:\n" + 
                        "  a - add to your lexicon (dictionary)?\n" + 
                        "  p - play the game?\n" +
                        "  q - quit?\n" + 
                        "enter the number \n>>") ;
      String play = s.nextLine() ;

      if (play.equals("q")) { // QUITTING
        is_play_over = false ;
      } 
      else if (play.equals("a")) { // ADD TO DICTIONARY
        //taking the words for the dictionary
        System.out.println("enter a word \n>>") ;
        String f = "" ;
        while (f.length() != 5) {
          System.out.print("only 5-letter words allowed:\n>>") ;
          f = s.nextLine() ;
        }
        ans.add(f.toUpperCase()) ;
      }
      else if (play.equals("p")) {// -- PLAY GAME
        //separation of key word and game
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + 
        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
        "Starting game now.") ;
        guess_count = 0 ;
        
        //setting the answer word to one from the dictionary
        String ans_word = ans.get((int)(Math.random()*ans.size())).toUpperCase() ;

        while (!is_game_over) {
          String guesses = "" ;

          //taking a guess
          System.out.println("enter your 5-letter guess") ;
          while (guesses.length() != 5) {
            System.out.print("only 5-letter words allowed:\n>>") ;
            guesses = s.nextLine() ;
          }
          guess_count += 1 ;

          //comparing
          String printing = "" ;
          boolean incorrect = false ;
          for(int i = 0; i < ans_word.length(); i++) {
            String ans_letter = ans_word.substring(i, i+1) ;
            String guess_letter = guesses.substring(i, i+1).toUpperCase() ;
            
            if(ans_letter.equals(guess_letter)) {
              printing += guess_letter + "   " ;
            }
            else if (ans_word.indexOf(guess_letter) != -1) {
              printing += "+" + guess_letter + "  " ;
              incorrect = true ;
            }
            else {
              printing += "*" + guess_letter + "  " ;
              incorrect = true ;
            }
          }

          //printing
          past_guesses.add(printing) ;
          for (String guess : past_guesses) {
            System.out.println(guess) ;
          }
          if (!incorrect) {
            System.out.println("*******************************\n" + 
                               "YOU WIN! \nGAME OVER!\n" + 
                               "You took " + guess_count + " guesses\n" +
                               "The word was: " + ans_word + 
                               "\n*******************************\n");    
            is_game_over = true ;  
          }
        }    
      } else { //bc sometimes people be dumb and don't follow instructions
      
      }
  
    }
  }
}


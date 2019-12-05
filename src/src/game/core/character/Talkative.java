/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.game.core.character;

import src.game.core.place.Place;

/**
 *
 * @author audrey
 */
public interface Talkative {

   /* private final static String SENTENCE_DEFAULT="Il fait beau aujourd'hui";
    private String sentence;
    
    Friendly(String nameOfPersonnage, Place placeOfStart, String sentenceOfCharacter){
        super(nameOfPersonnage, placeOfStart);
        this.sentence=sentenceOfCharacter;     
    }
    
    Friendly(String nameOfPersonnage, Place placeOfStart){
        super(nameOfPersonnage, placeOfStart);
        this.sentence=SENTENCE_DEFAULT;
    }*/
    
    public String getName();
    public String getSentence(); 
    public void setSentence(String sentence);
}

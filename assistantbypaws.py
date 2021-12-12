import os
import datetime
import pyttsx3 as tts
import speech_recognition as sr


engine = tts.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice',voices[0].id)
    
def speak(audio):
    engine.say(audio)
    engine.runAndWait()
    pass

def wishMe():
    h = int(datetime.datetime.now().hour)
    if h>=0 and h<12:
        speak("Good morning")
    elif h < 4:
        speak("Good afternoon")
    else:
        speak("Good evening")


def takeCommand():
    #mic input from user and returns string o/p
    speak("Tell me how can i help you")
    s = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        audio = s.listen(source)
        print("Listening done")
    try:
        print("Recognizing")
        query = s.recognize_bing(audio, language='en-in' )
        print("User said",query)
    except Exception as e:
        #print(e)
        print("Say that again....!")
        return "None"
    return query

if __name__ == '__main__':
    speak('Hai This is Paaws')
    wishMe()
    takeCommand()

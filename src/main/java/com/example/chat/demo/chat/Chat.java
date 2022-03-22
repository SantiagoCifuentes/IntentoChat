package com.example.chat.demo.chat;

public class Chat
{
    private String palabras;

    public Chat(String palabras) {
        this.palabras = palabras;
    }

    public String getPalabras() {
        return palabras;
    }

    public void setPalabras(String palabras) {
        this.palabras = palabras;
    }

    public Chat() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;

        Chat chat = (Chat) o;

        return palabras != null ? palabras.equals(chat.palabras) : chat.palabras == null;
    }

    @Override
    public int hashCode() {
        return palabras != null ? palabras.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "palabras='" + palabras + '\'' +
                '}';
    }
}

package SOLIDprinciples.LSP.Problem;

/*
Liskov Substitution Principle states that a child/derived class must be completely substitutable
for their base/parent class.
 */

public abstract class SocialMedia {
    // @supported by FB, Instagram
    public abstract void createPost(String msg);
    // @supported by FB, Instagram, WhatsApp, Telegram
    public abstract void chatWithFriend(String friendName, String msg);
    // @supported by FB, Instagram, WhatsApp
    public abstract void doVideoCall(String FriendName);
}

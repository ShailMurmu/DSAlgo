package SOLIDprinciples.LSP.Problem;

public class Telegram extends SocialMedia{
    @Override
    public void createPost(String msg) {
        // Not Supported
    }

    @Override
    public void chatWithFriend(String friendName, String msg) {
        // logic
    }

    @Override
    public void doVideoCall(String FriendName) {
        // Not Supported
    }
}

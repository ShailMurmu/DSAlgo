package SOLIDprinciples.LSP.Problem;

public class WhatsApp extends SocialMedia{
    @Override
    public void createPost(String msg) {
        // This is not supported
    }

    @Override
    public void chatWithFriend(String friendName, String msg) {
        // logic
    }

    @Override
    public void doVideoCall(String FriendName) {
        // logic
    }
}

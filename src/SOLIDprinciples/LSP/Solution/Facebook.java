package SOLIDprinciples.LSP.Solution;

public class Facebook implements SocialMedia, PostMediaManager, SocialVideoCallManager{
    @Override
    public void createPost(String msg) {
        // logic
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

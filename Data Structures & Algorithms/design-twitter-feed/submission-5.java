class Twitter {
    long timer;
    Map<Integer, List<Tweet>> userToTweet;
    Map<Integer, Set<Integer>> followerFollowee;

    public Twitter() {
        userToTweet = new HashMap<>();
        followerFollowee = new HashMap<>();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userToTweet.putIfAbsent(userId, new ArrayList<>());
        userToTweet.get(userId).add(new Tweet(tweetId, timer));
        timer++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>(Comparator.comparingLong((Tweet t) -> t.timestamp));
        Set<Integer> followees = followerFollowee.getOrDefault(userId, new HashSet<Integer>());
        followees.add(userId);
        // Add the followees tweets
        for (int user : followees) {
            List<Tweet> userTweets = userToTweet.getOrDefault(user, new ArrayList<>());
            int count = 0;
            for (int i = userTweets.size()-1; i >= 0; i--) {
                Tweet tweet = userTweets.get(i);
                if (count > 10) {
                    break;
                }
                feed.offer(tweet);
                if (feed.size() > 10) {
                    feed.poll();
                }
                count++;
            }
        }

        List<Integer> output = new ArrayList<>();
        while (!feed.isEmpty()) {
            output.add(feed.poll().tweetId);
        }
        Collections.reverse(output);
        return output;
    }
    
    public void follow(int followerId, int followeeId) {
        followerFollowee.putIfAbsent(followerId, new HashSet<Integer>());
        followerFollowee.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerFollowee.get(followerId) != null) {
            followerFollowee.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int tweetId;
        long timestamp;

        Tweet(int tweetId, long timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

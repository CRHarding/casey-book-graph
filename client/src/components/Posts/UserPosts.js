import React from 'react';
import SinglePost from './SinglePost';
import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';

const styles = theme => ({
  root: {
    flexGrow: 1,
  },
  card: {
    minWidth: 275,
  },
});

const UserPosts = props => {
  const user = props.user;
  const userPosts = props.posts;
  const friend = props.friend;
  const isUser = props.isUser;

  return (
    <Grid item xs>
      {userPosts.map((post, key) => {
        if (post) {
          return (
            <SinglePost
              post={post}
              key={key}
              user={user}
              friend={friend}
              isUser={isUser}
              manageDelete={props.manageDelete}
            />
          );
        } else {
          return null;
        }
      })}
    </Grid>
  );
};

export default withStyles(styles)(UserPosts);

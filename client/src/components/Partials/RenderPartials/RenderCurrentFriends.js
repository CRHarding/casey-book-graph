import React from 'react';
import { Link } from 'react-router-dom';

import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';

const styles = theme => ({
  root: {
    flex: 1,
  },

  title: {
    marginBottom: 16,
    fontSize: 14,
  },
});

const renderCurrentFriends = props => {
  const friend = props.friend;
  const key = props.key;
  const { classes } = props;
  const isUser = props.isUser;
  const user = props.user;

  let id;
  if (isUser) {
    id = user.id;
  } else {
    id = friend.id;
  }

  return (
    <Grid key={key}>
      <Paper key={key}>
        <Typography key={key} className={classes.title} color="textSecondary">
          {friend.id === id ? (
            <Link
              to={`/users/${friend.id}`}
              style={{ textDecoration: 'none' }}
              key={key}
            >
              {friend.receivedRequestUsername}
            </Link>
          ) : (
            <Link
              to={`/users/${friend.id}`}
              style={{ textDecoration: 'none' }}
              key={key}
            >
              {friend.sentRequestUsername}
            </Link>
          )}
        </Typography>
      </Paper>
    </Grid>
  );
};

export default withStyles(styles)(renderCurrentFriends);

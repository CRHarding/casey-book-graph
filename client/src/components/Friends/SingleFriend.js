import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';
import Grid from '@material-ui/core/Grid';

const styles = theme => ({
  card: {
    minWidth: 275,
  },
  title: {
    marginBottom: 16,
    fontSize: 14,
  },
  root: theme.mixins.gutters({
    paddingTop: 16,
    paddingBottom: 16,
    marginTop: theme.spacing.unit * 3,
  }),
  button: {
    margin: theme.spacing.unit,
  },
});

class SingleFriend extends Component {
  constructor(props) {
    super(props);
    this.state = {
      friend: this.props.friend,
      user: this.props.user,
    };
  }

  render() {
    const friend = this.state.friend;
    const user = this.state.user;

    const { classes } = this.props;
    const didSend = user.username === friend.sentRequestUsername;

    return (
      <Paper className={classes.root} elevation={4}>
        <Typography className={classes.title} color="textSecondary">
          Pending friend requests {didSend ? 'from' : 'to'}
        </Typography>
          {!didSend ? (
          <div>
            <Link
              to={`/users/${friend.id}`}
              style={{ textDecoration: 'none' }}
            >
              {friend.receivedRequestUsername}
            </Link>
            <Typography className={classes.title} color="textSecondary">
              from:
            </Typography>
            <Link
              to={`/users/${friend.id}`}
              style={{ textDecoration: 'none' }}
            >
              {friend.sentRequestUsername}
            </Link>
            <br/>
          </div>
        ) : (
          <div>
            <Link
              to={`/users/${friend.sentRequest}`}
              style={{ textDecoration: 'none' }}
            >
              {friend.sentRequestUsername}
            </Link>
            <Typography className={classes.title} color="textSecondary">
              to:
            </Typography>
            <Link
              to={`/users/${friend.id}`}
              style={{ textDecoration: 'none' }}
            >
              {friend.receivedRequestUsername}
            </Link>
            </div>
          )}
        {!didSend ? (
          <Grid>
            <Button
              variant="raised"
              size="small"
              onClick={() => this.props.handleFriendChoice(friend, true)}
            >
              Accept
            </Button>
            <Button
              variant="raised"
              size="small"
              onClick={() => this.props.handleFriendChoice(friend, false)}
            >
              Reject
            </Button>
          </Grid>
        ) : (
          ''
        )}
      </Paper>
    );
  }
}

export default withStyles(styles)(SingleFriend);

import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import Divider from '@material-ui/core/Divider';
import Paper from '@material-ui/core/Paper';

import EditPost from './EditPost';

const styles = theme => ({
  card: {
    minWidth: 275,
  },
  title: {
    marginBottom: 16,
    fontSize: 14,
  },
  button: {
    margin: theme.spacing.unit,
  },
  root: theme.mixins.gutters({
    paddingTop: 16,
    paddingBottom: 16,
    marginTop: theme.spacing.unit * 3,
  }),
});

class SinglePost extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showEditForm: false,
      post: this.props.post,
      user: this.props.user,
      friend: this.props.friend,
      isUser: this.props.isUser,
    };

    this.showEditForm = this.showEditForm.bind(this);
    this.manageEdit = this.manageEdit.bind(this);
  }

  showEditForm() {
    this.setState({
      showEditForm: !this.state.showEditForm,
    });
  }

  manageEdit(post) {
    console.log(post);
    this.setState({
      showEditForm: false,
    });
    this.props.manageEdit(post);
  }

  render() {
    const { classes } = this.props;
    const post = this.state.post;
    const user = this.state.user;
    const isUser = this.state.isUser;

    return (
      <Paper className={classes.root} elevation={4}>
        <Typography className={classes.title} color="textSecondary">
          <Link to={`/users/${user.id}`} style={{ textDecoration: 'none' }}>
            {post.posterUsername}'s post:{' '}
          </Link>
        </Typography>
        <Typography variant="headline" component="h2">
          {post.title}
        </Typography>
        <Divider />
        <br />
        <Typography component="p">{post.postText}</Typography>
        {isUser ? (
          <div>
            <IconButton
              className={classes.button}
              aria-label="Delete"
              onClick={() => this.props.manageDelete(post.id)}
            >
              <DeleteIcon />
            </IconButton>
            <IconButton
              className={classes.button}
              aria-label="edit"
              onClick={this.showEditForm}
            >
              <EditIcon />
            </IconButton>
          </div>
        ) : (
          ''
        )}
        {this.state.showEditForm ? (
          <EditPost
            post={post}
            user={user}
            manageEdit={() => this.manageEdit(post)}
          />
        ) : (
          ''
        )}
      </Paper>
    );
  }
}

export default withStyles(styles)(SinglePost);

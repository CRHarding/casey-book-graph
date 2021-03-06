import React, { Component } from 'react';
import { withStyles } from '@material-ui/core/styles';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import FormControl from '@material-ui/core/FormControl';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';

const styles = theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  formControl: {
    margin: theme.spacing.unit,
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200,
  },
  button: {
    margin: theme.spacing.unit,
  },
});

class PostForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      title: this.props.post.title,
      postText: this.props.post.postText,
      user: this.props.user,
      post: this.props.post,
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
    });
  };

  handleSubmit(event) {
    event.preventDefault();

    let post = this.state.post;
    post.title = this.state.title;
    post.postText = this.state.postText;
    post.posterUsername = this.state.user.username;
    this.props.manageEdit(post);
  }

  render() {
    const { classes } = this.props;

    return (
      <Grid item xs>
        <form
          className={classes.container}
          onSubmit={this.handleSubmit}
        >
          <div className={classes.container}>
            <FormControl className={classes.formControl}>
              <InputLabel htmlFor="title-simple">Title</InputLabel>
              <Input
                id="title-simple"
                label="title"
                onChange={this.handleChange('title')}
              />
            </FormControl>
          </div>
          <div className={classes.container}>
            <TextField
              id="textarea"
              rowsMax="12"
              label="postText"
              onChange={this.handleChange('postText')}
              placeholder="Content"
              multiline
              className={classes.textField}
            />
          </div>
          <Button
            type="submit"
            variant="raised"
            color="primary"
            className={classes.button}
          >
            Edit Post
          </Button>
        </form>
      </Grid>
    );
  }
}

export default withStyles(styles)(PostForm);

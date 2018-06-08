import React, { Component } from 'react';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';

const styles = theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200,
  },
  menu: {
    width: 200,
  },
});

class LoginForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      pristine: true,
      submitting: false,
    };
    this.reset = this.reset.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
      pristine: false,
    });
  };

  handleSubmit(e) {
    e.preventDefault();
    this.props.handleLoginSubmit(this.state.username);
  }

  reset() {
    this.setState({
      username: '',
      password: '',
      pristine: true,
      submitting: false,
    });
  }

  render() {
    const { classes } = this.props;
    return (
      <Grid>
        <Typography variant="headline" component="h3">
          Log In
        </Typography>
        <form onSubmit={this.handleSubmit}>
          <div>
            <TextField
              id="username"
              label="User Name"
              className={classes.textField}
              type="text"
              value={this.state.username}
              margin="normal"
              onChange={this.handleChange('username')}
            />
          </div>
          <div>
            <TextField
              id="password"
              label="Password"
              className={classes.textField}
              type="password"
              value={this.state.password}
              margin="normal"
              onChange={this.handleChange('password')}
            />
          </div>
          <div>
            <Button
              type="submit"
              disabled={this.state.pristine || this.state.submitting}
              onClick={this.handleSubmit}
            >
              Submit
            </Button>
            <Button
              type="button"
              disabled={this.state.pristine || this.state.submitting}
              onClick={this.reset}
            >
              Clear Values
            </Button>
          </div>
        </form>
      </Grid>
    );
  }
}

export default withStyles(styles)(LoginForm);

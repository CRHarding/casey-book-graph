import React, { Component } from 'react';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';

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
      firstName: '',
      lastName: '',
      email: '',
      aboutMe: '',
      password: '',
      repeatPassword: '',
      pristine: true,
      submitting: false,
    };
    this.reset = this.reset.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    const UserCreateInput = {
      username: this.state.username,
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      aboutMe: this.state.aboutMe,
      password: this.state.password,
    };

    this.props.createUser(UserCreateInput);
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
      pristine: false,
    });
  };

  reset() {
    this.setState({
      username: '',
      firstName: '',
      lastName: '',
      email: '',
      aboutMe: '',
      password: '',
      repeatPassword: '',
      pristine: true,
      submitting: false,
    });
  }

  render() {
    const { classes } = this.props;
    return (
      <form onSubmit={this.handleSubmit}>
        <Typography variant="headline" component="h3">
          Sign Up
        </Typography>
        <div>
          <TextField
            id="username"
            label="User Name"
            className={classes.textField}
            value={this.state.username}
            margin="normal"
            onChange={this.handleChange('username')}
          />
        </div>
        <div>
          <TextField
            id="SignUpFirstName"
            label="First Name"
            className={classes.textField}
            value={this.state.firstName}
            margin="normal"
            onChange={this.handleChange('firstName')}
          />
        </div>
        <div>
          <TextField
            id="SignUpLastName"
            label="Last Name"
            className={classes.textField}
            value={this.state.lastName}
            margin="normal"
            onChange={this.handleChange('lastName')}
          />
        </div>
        <div>
          <TextField
            id="SignUpEmail"
            label="Email"
            className={classes.textField}
            value={this.state.email}
            margin="normal"
            onChange={this.handleChange('email')}
          />
        </div>
        <div>
          <TextField
            id="SignUpAboutMe"
            label="About Me"
            multiline
            className={classes.textField}
            margin="normal"
            onChange={this.handleChange('aboutMe')}
          />
        </div>
        <div>
          <TextField
            id="SignUpPassword"
            label="Password"
            name="password"
            className={classes.textField}
            type="password"
            autoComplete="current-password"
            margin="normal"
            onChange={this.handleChange('password')}
          />
        </div>
        <div>
          <TextField
            id="SignUpRepeatPassword"
            label="Repeat Password"
            name="repeatPassword"
            className={classes.textField}
            type="password"
            margin="normal"
            onChange={this.handleChange('repeatPassword')}
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
    );
  }
}

export default withStyles(styles)(LoginForm);

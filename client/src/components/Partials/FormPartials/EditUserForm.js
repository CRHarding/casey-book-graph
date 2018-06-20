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

class EditUserForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userId: this.props.userId,
      username: '',
      firstName: '',
      lastName: '',
      email: '',
      aboutMe: '',
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
      id: 2,
      username: this.state.username,
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      aboutMe: this.state.aboutMe,
      password: 'RockSocks',
    };

    this.props.updateUser(UserCreateInput);
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
      pristine: false,
    });
  };

  reset() {
    this.setState({
      userName: '',
      firstName: '',
      lastName: '',
      email: '',
      aboutMe: '',
      pristine: true,
      submitting: false,
    });
  }

  render() {
    const { classes } = this.props;
    return (
      <form onSubmit={this.handleSubmit}>
        <Typography variant="headline" component="h3">
          Edit Your Information
        </Typography>
        <div>
          <TextField
            id="EditUsername"
            label="Username"
            className={classes.textField}
            value={this.state.username}
            margin="normal"
            onChange={this.handleChange('username')}
          />
        </div>
        <div>
          <TextField
            id="EditFirstName"
            label="First Name"
            className={classes.textField}
            value={this.state.firstName}
            margin="normal"
            onChange={this.handleChange('firstName')}
          />
        </div>
        <div>
          <TextField
            id="EditLastName"
            label="Last Name"
            className={classes.textField}
            value={this.state.lastName}
            margin="normal"
            onChange={this.handleChange('lastName')}
          />
        </div>
        <div>
          <TextField
            id="EditEmail"
            label="Email"
            className={classes.textField}
            value={this.state.email}
            margin="normal"
            onChange={this.handleChange('email')}
          />
        </div>
        <div>
          <TextField
            id="EditAboutMe"
            label="About Me"
            multiline
            className={classes.textField}
            margin="normal"
            onChange={this.handleChange('aboutMe')}
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

export default withStyles(styles)(EditUserForm);

export const validate = values => {
  const errors = {};
  const requiredFields = [
    'userName',
    'firstName',
    'lastName',
    'email',
    'aboutMe',
    'password',
    'repeatPassword',
  ];
  requiredFields.forEach(field => {
    if (!values[field]) {
      errors[field] = 'Required';
    }
  });
  if (
    values.email &&
    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)
  ) {
    errors.email = 'Invalid email address';
  }

  if (values.password !== values.repeatPassword) {
    errors.password = `Your passwords didn't match...`;
  }

  return errors;
};

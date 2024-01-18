Feature: Doc Strings
  Doc Strings are handy for passing a larger piece of text to a step definition.
  Doc Strings will be passed to the step definition as the last argument.

  Scenario: Doc Strings with three double-quote marks

    Given a blog post named "Random" with Markdown body
    """
    Some Title, Eh?
    ===============
    Here is the first paragraph of my blog post. Lorem ipsum dolor sit amet,
    consectetur adipiscing elit.
    """

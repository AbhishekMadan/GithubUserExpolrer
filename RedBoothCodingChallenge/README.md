# AeroFS Take Home Test - Android

Hello!

Thank you for your time commitment for doing this exercise.

As the next step in the AeroFS recruiting process, we'd like you to do this take-home exercise. It should take no longer than a couple hours for the basic requirements.

Please send us back your results within the next week. If there is a scheduling conflict and this time doesn't work for you, let us know and we'll push it back further.

Good luck, and we hope you have fun with this!



## Why do we do take-home exercise?

We are extremely aware of the fact that we are asking you for a time commitment. But here's why we still do it:

1. Code speaks louder than words! 
2. It helps us get to know you better as an engineer, and provides excellent conversation starters when we go over the code together.
3. This helps us reduce the number of stressful whiteboard interviews we need to do when you are on-site. You might agree, writing real code on a computer is so much better than whiteboards.



## What do you need to do?

You will be making single page application that takes in a **Github username and lists all public repositories** for that user. You may choose to show some extra information for the repositories, like number of forks, or stars.



#### What you'll need

1. **Project boilerplate** — You'll need the boilerplate where this Readme exists. The project has the `MainActivity` where you can start. You may make any changes as you'd like.

2. **Dependencies** — A minimal gradle file is included in the boilerplate along with a couple of dependencies already added in. You may decide to use those, or change to something else if you'd prefer that.  This is what it already has:

   1. Retrofit — Networking library, you may use this to make network requests

   Feel free to add more as you need.

3. **Assets** — The boilerplate does not include any image assets. For any assets you need, you may use stock images or placeholder text.

4. **Github API** — The Github endpoint you will need to get a list of repositories is, `https://api.github.com/users/<username>/repos`. You can give it a go by running `curl -i https://api.github.com/users/aerofs/repos`

   ​

#### What we're looking for

1. **Architecture** — The boilerplate is not opinionated because we want to leave that up to you. There is no right or wrong answer, but it is an amazing way for us to talk about your design decisions. **Bonus**: Think of how it can be designed to be generic to fetch other similar data, for example, public tweets of a user.
2. **User Interface** — This is another aspect we love to talk about. Our engineering team is a valuable contributor to our product design. Though they don't actively create mocks and assets, we need them to have excellent product sense and be passionate about the design of features they're working on. 
3. **Tests** (Bonus) — The app you're working on is small, and arguably doesn't need tests. But we would like to see what they would look like if you wrote them.


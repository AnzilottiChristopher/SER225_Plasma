---
layout: default
title: How To Use This Site
nav_order: 3
permalink: /HowToUseThisSite
search_exclude: true
---

## Table of contents
{: .no_toc .text-delta }

1. TOC
{:toc}

---

# How To Use This Site

This site contains documentation for this game created for Quinnipiac's SER225 class, mainly going over
how I made the game and how the code works. Games tend to be more complicated than the average application due to having many moving parts that all must work together,
the constant cycling of the game loop that has to always be looking out for user input and game state changes, and performance actually mattering. 
For that reason, it is important to understand (at least at a high-level) the game engine and game logic in order to successfully develop this game further.

Click a link from the sidebar on the left of this site to be taken to its respective web page.

The [Game Engine](../GameEngine/game-engine.md) section contains documents that detail the game engine code (how the game loop cycle works, etc.).

The [Game Code Details](../GameCodeDetails/game-code-details.md) section contains documents that detail the game logic code (map, player, entities, etc).

Other pages should be self-explanatory.

The search bar at the top of this site is your best friend. Without it, you will waste a lot of time combing through irrelevant pages of text
while trying to find what you're looking for. CTRL+F for keywords is another necessity for finding what you're looking for. If you are looking
at code and do not understand something, try typing it into the search of this website and see what comes up. Looking through subsections on the sidebar
can also help you find the correct pages you are looking for -- such as if you have a general idea of how to implement something but
aren't sure which class contains the logic that needs to be added to/changed.

## How was this site made?

GitHub has a platform called [GitHub Pages](https://pages.github.com/) that gives every GitHub user one free domain,
and each repository is given its own sub route. GitHub Pages will then, for free, host a website specified in that repo.
The content in the project's `docs` folder is what GitHub Pages uses to build and deploy the website code.

While websites are normally written using HTML, GitHub pages uses a web framework called [Jekyll](https://jekyllrb.com/) that
transforms plain text into HTML which can then be rendered in a web browser. 
The most common usage for this is using Jekyll to translate [markdown](https://www.markdownguide.org/basic-syntax/) formatted text files into HTML, which is what this site is written in. 
There is a bit of a learning curve to use Jekyll properly (something I didn't know how to use before attempting to make this site), 
but once I got it all figured out, things went smoothly and the website came out pretty good in my opinion. I used a Jekyll theme called [Just the Docs](https://pmarsceill.github.io/just-the-docs/) for this website, which gave me access to various features
and already implemented code/styles that made it a lot quicker to build up the site.

You are also allowed to embed HTML right into the markdown files, which I did in a few places when I needed do to an animation,
but otherwise there wasn't much of a need to do so, as this is a static site and doesn't need much logic to fulfill its purpose.

## Changing website information

Each page of this website has an associated `.md` (markdown) file inside the `docs` folder. To change data on the website, it's a simple matter of finding the correct markdown file and editing its text. 
Any changes pushed to the `master` branch will then be applied to the live website.

If you copied or forked this repo and want GitHub to create a new web page for your project (that will not conflict with this
existing website), you need to go to your GitHub repo's Settings, go to the
GitHub Pages section, and set the source to point to the `docs` folder instead of `none`. Once the website is built (if you wait a few minutes), 
it also give you the url that will lead to your project's site, which will be separate from mine.

![github-pages-source.png](../assets/images/github-pages-source.png)

If you are creating a new web page, I recommend copying an existing page's first several lines and editing them to make sure
it fits in the site correctly, as the theme will automatically include properly added pages to the sidebar.

## How to run this site locally

If you want to do some work to the site and find it too slow to wait for GitHub to propegate your changes, you can run this site locally. Only caveat is that it is not a 1:1 exact replica of how it will look on GitHub Pages, as GitHub Pages has its own "special stuff" going on that it lets you do that Jekyll does not have out of the box, and the environment GitHub runs the site on is probably a lot different than your computer. It's not a big deal though, just be aware that you may run into a situation where something is working on GitHub Pages but not locally or vice verca. Of course in this situation, the only answer is to go with the option that works on GitHub Pages, since that's where the site is hosted.

To run this site locally:

1. Install and setup Jekyll.
    1. For Windows, follow the instructions [here](https://jekyllrb.com/docs/installation/windows/) for installation and setup of Jekyll via RubyInstaller.
    1. For MacOS, follow the instructions [here](https://jekyllrb.com/docs/installation/macos/) for installation and setup of Jekyll via Homebrew.
2. cd into the root website folder
3. Run `bundle install` to install all required external packages for the website.
   1. If you see an error saying something about incompatible Ruby versions, delete the `Gemfile.lock` file and try running this command again.
4. Run `bundle exec jekyll serve` to build and serve the site. If there are no errors and you see **Server address: http://127.0.0.1:4000**, that means it worked. In a web browser (preferably Google Chrome), type **localhost:4000** in the address bar and hit enter. You should see the site.

If you make changes to the site's code while running the site locally and hit save, you can refresh the web page to see your new changes. Sometimes it takes a few seconds to propagate. If you are still not seeing your changes applied, it might be due to caching -- in which case, do a hard refresh on the web page. 
To do a hard refresh on Windows in Google Chrome, hold the Ctrl button and click the refresh button at the same time. To do a hard refresh on MacOS in Google Chrome, hold the Shift button and hit the refresh button at the same time.


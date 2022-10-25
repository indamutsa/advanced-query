const { User } = require("../models/User");
const { Workspace } = require("../models/Workspace");
const { Project } = require("../models/Project");

const loadInitData = async () => {
  let user = await User.findOne({ username: "arsene" });

  if (user) {
    return;
  } else {
    try {
      let newUser = await User({
        username: "arsene",
        email: "arsene@gmail.com",
      });

      const savedUser = await newUser.save();

      const workspace = await saveDefaultWorkspace(savedUser);
      await saveDefaultProject(workspace);
    } catch (error) {
      console.log(error);
    }
  }
};

const saveDefaultWorkspace = async (user) => {
  try {
    const workspace = await Workspace({
      name: "default-workspace",
      owner: user._id,
      description: "Default workspace",
    });
    const savedWorkspace = await workspace.save();

    return savedWorkspace;
  } catch (error) {
    console.log(error);
  }
};

const saveDefaultProject = async (workspace) => {
  try {
    const project = await Project({
      name: "Default-project",
      workspace: workspace._id,
      user: workspace.owner,
      description: "Default Project",
    });
    const savedProject = await project.save();

    await Workspace.findByIdAndUpdate(
      workspace._id,
      {
        $push: {
          projects: savedProject._id,
        },
      },
      {
        new: true, //To return the updated value
      }
    );
  } catch (error) {
    console.log(error);
  }
};

module.exports = { loadInitData };
